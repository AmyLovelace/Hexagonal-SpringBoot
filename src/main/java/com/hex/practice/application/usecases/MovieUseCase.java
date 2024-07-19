package com.hex.practice.application.usecases;


import com.hex.practice.application.dao.MovieDAO;
import com.hex.practice.application.dto.NewMovieDto;
import com.hex.practice.domain.Movie;
import com.hex.practice.infrastructure.exceptions.ErrorCode;
import com.hex.practice.infrastructure.exceptions.MovieAlreadyExistException;
import com.hex.practice.infrastructure.exceptions.MovieNotFoundException;
import jakarta.servlet.ServletOutputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieUseCase {

    private final MovieDAO movie;

    public String saveMovie(NewMovieDto newMovieDto){

        //check if the movie is already in DB ** business logic **
        var isPresent = movie.findMovieByTitle(newMovieDto.title()).isPresent();
        System.out.println(isPresent +"está presente");
        if(isPresent){throw new MovieAlreadyExistException(ErrorCode.MOVIE_ALREADY_EXISTS);}

        //save movie if is NOT present
        movie.saveMovie(newMovieDto);

        return "Movie Save Successfully";
    }

    public List<Movie> getAllMovies(){
        return movie.findAllMovies();
    }


    public String updateMovie(Movie updatedMovie)throws MovieNotFoundException{

        var isPresent = movie.findMovieByTitle(updatedMovie.title()).isPresent();
        if(!isPresent){throw new MovieNotFoundException(ErrorCode.MOVIE_NOT_FOUND);}

        movie.updateMovie(updatedMovie);

        return "Movie updated Successfully";


    }

    public Movie findMovieByTitle(String title){

        return movie.findMovieByTitle(title).orElseThrow(
        ()-> new MovieNotFoundException(ErrorCode.MOVIE_NOT_FOUND));



    }
}
