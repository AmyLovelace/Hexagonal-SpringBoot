package com.hex.practice.application.dto;

import java.time.LocalDateTime;

public record NewMovieDto(
                          String title,
                          String description,
                          LocalDateTime releaseDate,
                          String directorName) {
}
