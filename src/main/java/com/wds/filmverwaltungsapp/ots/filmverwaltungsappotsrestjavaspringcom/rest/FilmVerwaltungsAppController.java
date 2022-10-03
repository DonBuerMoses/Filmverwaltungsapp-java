package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.rest;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.FilmeDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.SpeichermedienDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class FilmVerwaltungsAppController {

    @Autowired
    FilmeDao filmeDao;

    @Autowired
    SpeichermedienDao speichermedienDao;


    @GetMapping(path = "/filme")
    public List<Film> getAllFilme() {

        return filmeDao.getAllFilme();
    }

    @GetMapping(path = "/speichermedien")
    public List<Speichermedium> getAllSpeichermedien() {

        return speichermedienDao.getAllSpeichermedien();
    }

    @PutMapping(path = "filme/{film_ID}/{email}")
    public ResponseEntity<Void> UpdateFilmeById(@PathVariable int film_ID, @PathVariable int email, @RequestBody Film film) {

        System.out.println(film);
        int updateCount = filmeDao.updateFilm(film);
        if (updateCount == 1) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "filme")
    public ResponseEntity<Void> insertFilm(@RequestBody Film film) {

        System.out.println(film);
        film.setFilm_ID(filmeDao.getMaxId() + 1);
        if (filmeDao.insertFilm(film) == 1) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "filme/{film_ID}/{email}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int film_ID, @PathVariable String email) {

        System.out.println(film_ID + ' ' + email);
        if (filmeDao.deleteFilm(film_ID, email) == 1) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
