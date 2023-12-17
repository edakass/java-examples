package com.example.FilmApp.service;


import com.example.FilmApp.domain.Film;
import com.example.FilmApp.dto.FilmDTO;
import com.example.FilmApp.exception.ResourceNotFoundException;
import com.example.FilmApp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    // NOT : GET ALL FILMS
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // NOT : CREATE A NEW FILM
    public void createNewFilm(Film film) {
        filmRepository.save(film);
    }

    // NOT : GET A FILM
    public Film findFilm(Long id) {

        return filmRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id + "movie number not found"));
    }

    // NOT : DELETE FILM
    public void deleteFilm() {
        Film film = new Film();
        filmRepository.delete(film);
    }


    /* Update işleminde dto oluşturcaz, bi nevi entityi kopyalıcaz.
       Bütün her şeyi göndermeyeceğizde sadece ihtiyaç duyulan şeyleri göndercez.
       Bi nevi güvenlik önlemi almış olcaz, fazla veri göndermekten kurtulmuş olacağız.
     */
    // NOT : UPDATE FILM
    public void updateFilm(Long id, FilmDTO filmDTO) {
        Film film = findFilm(id);

        film.setFilmName(filmDTO.getFilmName());
        film.setReleaseYear(filmDTO.getReleaseYear());
        film.setImdbRating(filmDTO.getImdbRating());
        film.setProducer(filmDTO.getProducer());
        film.setGenre(filmDTO.getGenre());

        filmRepository.save(film);
    }
}
