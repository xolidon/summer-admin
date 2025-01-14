package com.pulip.summer.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "sm_users")
@Entity
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String email;
    private String role;
    private String status;
    @CreatedBy
    private LocalDateTime createdAt;
    @LastModifiedBy
    private LocalDateTime updatedAt;
}
