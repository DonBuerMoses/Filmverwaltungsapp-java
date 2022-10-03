package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.logic;

public class FilmInformation {

    /*public List<FilmInfoModel> getFilmInfoModels(FilmeDao filmeDao) {
        List<Film> filme = filmeDao.getAllFilme();
        List<FilmInfoModel> filmInfoModels = new ArrayList<>();
        List<FilmRegisseur> filmeRegisseure = filmeRegisseureDao.getAllFilmeRegisseure();
        for(int i = 0; i < filme.size(); i++) {
            Film film = filme.get(i);
            List<FilmRegisseur> filmRegisseure = filmeRegisseure.stream()
                    .filter(filmRegisseur -> filmRegisseur.getFilm_ID() == film.getFilm_ID())
                    .peek(x -> System.out.println(x))
                    .collect(Collectors.toList());
            List<Regisseur> regisseure = filmRegisseure.stream()
                    .map(filmRegisseur -> regisseureDao.getRegisseur(filmRegisseur.getRegisseurID()))
                    .peek(x -> System.out.println(x))
                    .collect(Collectors.toList());
            filmInfoModels.add(new FilmInfoModel(film, regisseure));

        }

        return filmInfoModels;
    }*/
}
