package com.team9backend._project3_backend.dto;

public class UserResponseDto {
    private Long userId;
    private String username;
    private String email;
    private String displayName;
    private String profilePictureUrl;
    private String role;
    private Boolean isActive;

    public UserResponseDto() {}

    public UserResponseDto(Long userId, String username, String email,
                           String displayName, String profilePictureUrl,
                           String role, Boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.profilePictureUrl = profilePictureUrl;
        this.role = role;
        this.isActive = isActive;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getProfilePictureUrl() { return profilePictureUrl; }
    public void setProfilePictureUrl(String profilePictureUrl) { this.profilePictureUrl = profilePictureUrl; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }
}