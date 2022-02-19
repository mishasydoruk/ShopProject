package com.example.xyeta.DTO.Responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class DisplayUserDTO {
    private UUID uuid;
    private String username;
    private String email;
    private LocalDateTime registration_date;
}
