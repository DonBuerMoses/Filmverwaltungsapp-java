package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.logic;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.FilmeDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db.SpeichermedienDao;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.model.FilmInfoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmInformation {

    /*public List<FilmInfoModel> getFilmInfoModels(FilmeDao filmeDao) {
        List<Film> filme = filmeDao.getAllFilme();
        List<FilmInfoModel> filmInfoModels = new ArrayList<>();
        List<Speichermedium> speichermedien = SpeichermedienDao.getAllSpeichermedien();
        for(int i = 0; i < filme.size(); i++) {
            Film film = filme.get(i);
            List<Speichermedium> regisseure = filmRegisseure.stream()
                    .map(filmRegisseur -> SpeichermedienDao.getRegisseur(filmRegisseur.getRegisseurID()))
                    .peek(x -> System.out.println(x))
                    .collect(Collectors.toList());
            filmInfoModels.add(new FilmInfoModel(film, regisseure));

        }

        return filmInfoModels;
    }*/
}
