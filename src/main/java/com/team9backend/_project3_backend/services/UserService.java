package com.team9backend._project3_backend.services;

import com.team9backend._project3_backend.dto.UserResponseDto;
import com.team9backend._project3_backend.models.User;
import com.team9backend._project3_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getDisplayName(),
                user.getProfilePictureUrl(),
                user.getRole(),
                user.getIsActive()
        );
    }
}
