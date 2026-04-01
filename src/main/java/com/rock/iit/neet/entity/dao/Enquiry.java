package com.rock.iit.neet.entity.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "enquiries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(name = "interested_in")
    private String interestedIn;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "class")
    private String grade;

    private String parentName;
    private String parentPhoneNumber;
    private String status;
    private String reason;
}
