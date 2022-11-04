package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.rest;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.FilmeDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.NutzerDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.SpeichermedienDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Nutzer;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.logic.FilmInformation;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.model.FilmInfoModel;
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

    /**
     * Konstuktor
     * @param filmeDao
     * @param speichermedienDao
     * @param nutzerDao
     */
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

    @GetMapping(path = "speichermedien/{speichermedien_id}")
    public Speichermedium getSpeichermediumById(@PathVariable int speichermedien_id) {
        return speichermedienDao.getSpeichermediumById(speichermedien_id);
    }

    @GetMapping(path = "/nutzer")
    public List<Nutzer> getAllNutzer() {

        return nutzerDao.getAllNutzer();
    }

    @GetMapping(path = "filme/{email}")
    public List<Film> getAllFilmeOfNutzerbyEmail(@PathVariable String email) {
        return filmeDao.getAllFilmeOfNutzer(email);
    }

    @GetMapping(path = "filme/{email}/{film_ID}")
    public Film getFilmbyId(@PathVariable int film_ID, @PathVariable String email) {
        return filmeDao.getFilmById(film_ID, email);
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

    @GetMapping(path = "/filmeinfos")
    public List<FilmInfoModel> getAllFilmeInfos() {
        return (new FilmInformation().getAllFilmeInfos(filmeDao, speichermedienDao));
    }

    @GetMapping(path = "/filmeinfos/{email}")
    public List<FilmInfoModel> getFilmeInfosOfNutzer(@PathVariable String email) {
        return (new FilmInformation().getFilmeInfosOfNutzer(filmeDao, speichermedienDao, email));
    }

    @GetMapping(path = "/filmeinfos/{email}/{film_ID}")
    public FilmInfoModel getFilmeInfoOfNutzerById(@PathVariable Integer film_ID, @PathVariable String email) {
        return (new FilmInformation().getFilmeInfoOfNutzerById(filmeDao, speichermedienDao, film_ID, email));
    }
}
