package com.example.FilmApp.controller;

import com.example.FilmApp.domain.Film;
import com.example.FilmApp.dto.FilmDTO;
import com.example.FilmApp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("films")
@CrossOrigin(origins = "http://localhost:5500")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // NOT : GET ALL FILMS
    @GetMapping // http://localhost:5500/films + GET
    public ResponseEntity<List<Film>> listAllFilms() {
        List<Film> films = filmService.getAllFilms();

        return ResponseEntity.ok(films);
    }

    // NOT : CREATE A NEW FILM
    @PostMapping // http://localhost:5500/films + POST + JSON
    public ResponseEntity<Map<String, String>> createFilm(@Valid @RequestBody Film film) {
        filmService.createNewFilm(film);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Movie added successfully");
        map.put("status", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED); // http status code = 201
    }

    // NOT : GET A FILM
    @GetMapping("/{id}") // http:localhost:5500/films/1 + GET
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(filmService.findFilm(id));
    }

    // NOT : DELETE FILM
    @DeleteMapping("/{id}") // http:localhost:5500/films/1 + DELETE
    public ResponseEntity<String> deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilm();

        String message = "Movie deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK); // 200
    }

    // NOT : UPDATE FILM
    @PutMapping("/{id}") // http:localhost:5500/films/1 + PUT + JSON
    public ResponseEntity<String> updateFilm(@PathVariable("id") Long id,
                                             @Valid @RequestBody FilmDTO filmDTO) {
        filmService.updateFilm(id, filmDTO);

        String message = "The movie has been updated successfully.";
        return new ResponseEntity<>(message, HttpStatus.OK); // 200
    }
}
