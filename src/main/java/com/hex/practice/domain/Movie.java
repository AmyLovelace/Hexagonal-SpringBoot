package com.hex.practice.domain;

import java.time.LocalDateTime;

public record Movie(
        Long id,
        String title,
        String description,
        LocalDateTime releaseDate,
        String directorName
) {





}
