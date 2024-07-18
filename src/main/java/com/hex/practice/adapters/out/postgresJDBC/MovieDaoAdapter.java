package com.hex.practice.adapters.out.postgresJDBC;

import com.hex.practice.adapters.out.postgresJDBC.entities.MovieEntity;
import com.hex.practice.adapters.out.postgresJDBC.repositories.MovieRepository;
import com.hex.practice.application.dao.MovieDAO;
import com.hex.practice.application.dto.NewMovieDto;
import com.hex.practice.domain.Movie;
import com.hex.practice.infrastructure.exceptions.ErrorCode;
import com.hex.practice.infrastructure.exceptions.MovieAlreadyExistException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class MovieDaoAdapter implements MovieDAO {

    private  final MovieRepository movieRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return  movieRepository.findMovieByTitle(title);

    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) movieRepository.findAll())
               .stream()
               .map(movieEntity -> {
                   return new Movie(movieEntity.id, movieEntity.title, movieEntity.description, movieEntity.releaseDate, movieEntity.directorName
                   );
               }).toList();
    }

    @Override
    public void saveMovie(NewMovieDto newMovie) {
        //PARQ GUARDAR UNA MOVIE NECESITO VERIFICAR QUE NO EXISTA Y LUEGO GUARDARLA
        var movie = movieRepository.findMovieByTitle(newMovie.title());

        if(movie.isPresent()){
            throw new MovieAlreadyExistException(ErrorCode.MOVIE_ALREADY_EXISTS);
        }
        movieRepository.save(new MovieEntity(null, newMovie.title(), newMovie.description(),newMovie.releaseDate(), newMovie.directorName(),null));
    }

    @Override
    public void deleteMovie(Movie deletedMovie) {

    }

    @Override
    public void updateMovie(Movie updatedMovie) {

    }
}
