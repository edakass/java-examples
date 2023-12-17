package com.example.FilmApp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //getter setter oluşturduk, setter da id gözüküyor , id nin setterı yapmasını istemiyoruz otomatik oluşturacağı için
    @Setter(AccessLevel.NONE) //bunu ayrı tutmuş olduk
    private Long id;

    @NotBlank(message = "movie name cannot be empty!")
    @Size(min = 2, max = 50, message = "Movie name '${validatedValue}' must be betwee! {min} and {max}")
    @Column(nullable = false, length = 50)
    private String filmName;

    @NotBlank(message = "movie release year cannot be empty!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "movie producer cannot be empty!")
    @Size(min = 2, max = 20, message = "Movie producer '${validatedValue}' must be betwee! {min} and {max}")
    @Column(nullable = false, length = 20)
    private String producer;

    @NotBlank(message = "movie genre cannot be empty!")
    @Size(min = 2, max = 25, message = "Movie genre '${validatedValue}' must be betwee! {min} and {max}")
    @Column(nullable = false, length = 25)
    private String genre;
}
