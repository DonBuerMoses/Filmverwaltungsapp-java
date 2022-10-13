package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.rest;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.FilmeDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.NutzerDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.SpeichermedienDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Nutzer;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class FilmVerwaltungsAppController {

    FilmeDao filmeDao;
    SpeichermedienDao speichermedienDao;
    NutzerDao nutzerDao;

    public FilmVerwaltungsAppController(FilmeDao filmeDao, SpeichermedienDao speichermedienDao, NutzerDao nutzerDao) {
        this.filmeDao = filmeDao;
        this.speichermedienDao = speichermedienDao;
        this.nutzerDao = nutzerDao;
    }


    @GetMapping(path = "/filme")
    public List<Film> getAllFilme() {

        return filmeDao.getAllFilme();
    }

    @GetMapping(path = "/speichermedien")
    public List<Speichermedium> getAllSpeichermedien() {

        return speichermedienDao.getAllSpeichermedien();
    }

    @GetMapping(path = "/nutzer")
    public List<Nutzer> getAllNutzer() {

        return nutzerDao.getAllNutzer();
    }

    @GetMapping(path = "filme/{email}")
    public List<Film> getAllFilmeOfNutzerbyEmail(@PathVariable String email) {
        return filmeDao.getAllFilmeOfNutzer(email);
    }

    @GetMapping(path = "filme/{email}/{film_id}")
    public Film getFilmbyId(@PathVariable int film_id, @PathVariable String email) {
        return filmeDao.getFilmById(film_id, email);
    }

    @PutMapping(path = "filme/{email}/{film_ID}")
    public ResponseEntity<Void> updateFilmeById(@PathVariable int film_ID, @PathVariable String email, @RequestBody Film film) {

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

    @DeleteMapping(path = "filme/{email}/{film_ID}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int film_ID, @PathVariable String email) {

        System.out.println(film_ID + ' ' + email);
        if (filmeDao.deleteFilm(film_ID, email) == 1) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
