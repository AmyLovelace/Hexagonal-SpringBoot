package com.hex.practice.adapters.out.postgresJDBC.entities;

import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;


@Table(name = "movies")
@AllArgsConstructor
public class MovieEntity {
    @Id
    public Long id;
    public String title;
    public String description;
    @Column("release_date")
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime releaseDate;
    @Column("director_name")
    public String directorName;
    @Version
    Integer version;


}
