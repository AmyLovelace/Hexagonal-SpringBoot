package com.hex.practice.adapters.out.postgresJDBC.repositories;

import com.hex.practice.adapters.out.postgresJDBC.entities.MovieEntity;
import com.hex.practice.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity,Long> {

    @Query("select * from where title =:title")
    Optional<Movie> findMovieByTitle(@Param("title") String title);
}
