package com.SprintI.SocialMeli.dtos.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private LocalDateTime timestamp;
}
