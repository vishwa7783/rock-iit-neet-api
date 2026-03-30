-- =========================
-- EXTENSIONS
-- =========================
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =========================
-- ENUMS
-- =========================
CREATE TYPE attendance_status AS ENUM ('present', 'absent', 'late');
CREATE TYPE payment_status AS ENUM ('pending', 'completed', 'failed');
CREATE TYPE user_role AS ENUM ('admin', 'teacher');

-- =========================
-- USERS (AUTH SYSTEM)
-- =========================
CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    phone VARCHAR UNIQUE,
    role user_role NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- =========================
-- COURSES
-- =========================
CREATE TABLE courses (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    subtitle VARCHAR,
    description TEXT,
    target_classes VARCHAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID
);

-- =========================
-- BATCHES
-- =========================
CREATE TABLE batches (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    course_id BIGINT NOT NULL,
    start_date DATE,
    end_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID,

    CONSTRAINT fk_batches_course FOREIGN KEY (course_id) REFERENCES courses(id)
);

-- =========================
-- STUDENTS
-- =========================
CREATE TABLE students (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    phone VARCHAR UNIQUE NOT NULL,
    course_id BIGINT NOT NULL,
    batch_id BIGINT NOT NULL,
    attendance_percentage FLOAT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID,

    CONSTRAINT fk_students_course FOREIGN KEY (course_id) REFERENCES courses(id),
    CONSTRAINT fk_students_batch FOREIGN KEY (batch_id) REFERENCES batches(id)
);

CREATE INDEX idx_students_course ON students(course_id);
CREATE INDEX idx_students_batch ON students(batch_id);

-- =========================
-- TEACHERS
-- =========================
CREATE TABLE teachers (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR NOT NULL,
    phone VARCHAR UNIQUE NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID
);

-- =========================
-- CLASS SCHEDULE
-- =========================
CREATE TABLE class_schedules (
    id BIGSERIAL PRIMARY KEY,
    subject VARCHAR NOT NULL,
    topic VARCHAR NOT NULL,
    class_date DATE NOT NULL,
    class_time TIME NOT NULL,
    teacher_id UUID NOT NULL,
    batch_id BIGINT NOT NULL,
    room VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID,

    CONSTRAINT fk_schedule_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id),
    CONSTRAINT fk_schedule_batch FOREIGN KEY (batch_id) REFERENCES batches(id)
);

CREATE INDEX idx_schedule_teacher ON class_schedules(teacher_id);
CREATE INDEX idx_schedule_batch ON class_schedules(batch_id);

-- =========================
-- ATTENDANCE
-- =========================
CREATE TABLE attendances (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    class_schedule_id BIGINT NOT NULL,
    status attendance_status NOT NULL,
    date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID,

    CONSTRAINT fk_attendance_student FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_attendance_schedule FOREIGN KEY (class_schedule_id) REFERENCES class_schedules(id),

    CONSTRAINT unique_attendance UNIQUE (student_id, class_schedule_id)
);

CREATE INDEX idx_attendance_student ON attendances(student_id);

-- =========================
-- TESTS
-- =========================
CREATE TABLE tests (
    id BIGSERIAL PRIMARY KEY,
    subject VARCHAR NOT NULL,
    total_marks INT NOT NULL,
    test_date DATE NOT NULL,
    batch_id BIGINT NOT NULL,

    CONSTRAINT fk_tests_batch FOREIGN KEY (batch_id) REFERENCES batches(id)
);

-- =========================
-- TEST SCORES
-- =========================
CREATE TABLE test_scores (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    test_id BIGINT NOT NULL,
    score INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_scores_student FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_scores_test FOREIGN KEY (test_id) REFERENCES tests(id),

    CONSTRAINT unique_score UNIQUE (student_id, test_id)
);

-- =========================
-- PAYMENTS
-- =========================
CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status payment_status NOT NULL,
    method VARCHAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_payment_student FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE INDEX idx_payment_student ON payments(student_id);

-- =========================
-- ENQUIRY
-- =========================
CREATE TABLE public.enquiries (
	id uuid DEFAULT uuid_generate_v4() NOT NULL,
	"name" varchar NOT NULL,
	email varchar NOT NULL,
	phone varchar NOT NULL,
	interested_in varchar NULL,
	school_name varchar NULL,
	"class" varchar NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	created_by uuid NULL,
	updated_at timestamp NULL,
	updated_by uuid NULL,
	parent_name varchar NULL,
	parent_phone_number varchar NULL,
	CONSTRAINT enquiries_pkey PRIMARY KEY (id)
);