package com.example.FilmApp.dto;

import com.example.FilmApp.domain.Film;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private Long id;

    @NotBlank(message = "movie name cannot be empty")
    @Size(min = 2, max = 50, message = "Movie name '${validatedValue}' must be betwee! {min} and {max}!")
    private String filmName;

    @NotBlank(message = "movie release year cannot be empty!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "movie producer cannot be empty!")
    @Size(min = 2, max = 20, message = "Movie producer '${validatedValue}' must be betwee! {min} and {max}")
    private String producer;

    @NotBlank(message = "movie genre cannot be empty!")
    @Size(min = 2, max = 25, message = "Movie genre '${validatedValue}' must be betwee! {min} and {max}!")
    private String genre;

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.filmName = film.getFilmName();
        this.releaseYear = film.getReleaseYear();
        this.imdbRating = film.getImdbRating();
        this.producer = film.getProducer();
        this.genre = film.getGenre();
    }

    //this.id , yani this olanlar bu sayfadakileri ifade ediyor
}
