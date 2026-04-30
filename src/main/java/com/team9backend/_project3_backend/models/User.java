package com.team9backend._project3_backend.models;

import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "\"User\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(nullable = false)
    private String role = "USER";

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public User() {}

    // Automatically set timestamps
    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    //Setters and Getters

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPasswordHash() {return passwordHash;}

    public void setPasswordHash(String passwordHash) {this.passwordHash = passwordHash;}

    public String getDisplayName() {return displayName;}

    public void setDisplayName(String displayName) {this.displayName = displayName;}

    public String getProfilePictureUrl() {return profilePictureUrl;}

    public void setProfilePictureUrl(String profilePictureUrl) {this.profilePictureUrl = profilePictureUrl;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public Boolean getIsActive() {return isActive;}

    public void setIsActive(Boolean active) {isActive = active;}

    public Instant getCreatedAt() {return createdAt;}

    public Instant getUpdatedAt() {return updatedAt;}
}