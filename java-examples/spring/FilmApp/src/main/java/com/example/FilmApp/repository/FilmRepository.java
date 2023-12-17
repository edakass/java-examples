package com.example.FilmApp.repository;

import com.example.FilmApp.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
