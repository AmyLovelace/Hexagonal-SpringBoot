package com.hex.practice.application.dao;

import com.hex.practice.application.dto.NewMovieDto;
import com.hex.practice.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {


   Optional<Movie> findMovieByTitle(String title);

   List<Movie> findAllMovies();

   void saveMovie(NewMovieDto newMovie);

   void deleteMovie(Movie deletedMovie);

   void updateMovie(Movie updatedMovie);





}
