package com.hex.practice.adapters.in.web;

import com.hex.practice.application.dto.NewMovieDto;
import com.hex.practice.application.usecases.MovieUseCase;
import com.hex.practice.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieUseCase movieUsecase;

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        return ResponseEntity.ok(movieUsecase.getAllMovies());

    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        System.out.println(title);
        return ResponseEntity.ok(movieUsecase.findMovieByTitle(title));



    }

    @PostMapping
    public ResponseEntity<?> postMovie(@RequestBody NewMovieDto newMovieDto) {

        System.out.println(
                newMovieDto +"NUEVA PELICULA POST"
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUsecase.saveMovie(newMovieDto));




    }

    @PutMapping
    public ResponseEntity<?> postMovie(@RequestBody Movie newMovie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUsecase.updateMovie(newMovie));

    }

    ///add implementation of delete mapping
}
