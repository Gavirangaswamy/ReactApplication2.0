package com.dxctechnology.reactapplication.DTO;

import lombok.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String confirmPassword;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}