package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.model;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmInfoModel {

    private Film film;
    private Speichermedium speichermedium;


}
