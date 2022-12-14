package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.logic;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.FilmeDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.SpeichermedienDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.model.FilmInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Enthält alle Funktionen um die gewünschte FilmInfoModel-JSON zu bauen
 */
public class FilmInformation {

    /**
     * holt alle FilmeInfos
     * @param filmeDao
     * @param speichermedienDao
     * @return
     */
    public List<FilmInfoModel> getAllFilmeInfos(FilmeDao filmeDao, SpeichermedienDao speichermedienDao) {
        List<Film> filme = filmeDao.getAllFilme();
        List<FilmInfoModel> filmInfoModels = new ArrayList<>();
        //List<Speichermedium> speichermedien = speichermedienDao.getAllSpeichermedien();
        for(int i = 0; i < filme.size(); i++) {
            Film film = filme.get(i);
            Speichermedium speichermedium = speichermedienDao.getSpeichermediumById(film.getSpeichermedien_id());
            filmInfoModels.add(new FilmInfoModel(film.getFilm_ID(), film.getEmail(), film.getBewertung(), film.isFavorit(), speichermedium.getSpeichermedien_ID(), speichermedium.getBezeichnung()));

        }

        return filmInfoModels;
    }

    /**
     * holt die FilmeInfos eines bestimmten Nutzers
     * @param filmeDao
     * @param speichermedienDao
     * @param email
     * @return
     */
    public List<FilmInfoModel> getFilmeInfosOfNutzer(FilmeDao filmeDao, SpeichermedienDao speichermedienDao, String email) {
        List<Film> filme = filmeDao.getAllFilmeOfNutzer(email);
        List<FilmInfoModel> filmInfoModels = new ArrayList<>();
        for(int i = 0; i < filme.size(); i++) {
            Film film = filme.get(i);
            Speichermedium speichermedium = speichermedienDao.getSpeichermediumById(film.getSpeichermedien_id());
            filmInfoModels.add(new FilmInfoModel(film.getFilm_ID(), film.getEmail(), film.getBewertung(), film.isFavorit(), speichermedium.getSpeichermedien_ID(), speichermedium.getBezeichnung()));

        }

        return filmInfoModels;
    }


    /**
     * holt die FilmeInfos eines bestimmten Nutzers von einem bestimmten Film
     * @param filmeDao
     * @param speichermedienDao
     * @param film_ID
     * @param email
     * @return
     */
    public FilmInfoModel getFilmeInfoOfNutzerById(FilmeDao filmeDao, SpeichermedienDao speichermedienDao, Integer film_ID, String email) {
        Film film = filmeDao.getFilmById(film_ID, email);
        //= new FilmInfoModel();
        Speichermedium speichermedium = speichermedienDao.getSpeichermediumById(film.getSpeichermedien_id());
        FilmInfoModel filmInfoModel = new FilmInfoModel(film.getFilm_ID(), film.getEmail(), film.getBewertung(), film.isFavorit(), speichermedium.getSpeichermedien_ID(), speichermedium.getBezeichnung());


        return filmInfoModel;
    }
}
