package com.hex.practice.adapters.out.postgresJDBC.entities;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
@Table(name = "Movies")
@AllArgsConstructor
public class MovieEntity {
    @Id
    public Long id;
    public String title;
    public String description;
    public LocalDateTime releaseDate;
    public String directorName;
    @Version
    Integer version;


}
