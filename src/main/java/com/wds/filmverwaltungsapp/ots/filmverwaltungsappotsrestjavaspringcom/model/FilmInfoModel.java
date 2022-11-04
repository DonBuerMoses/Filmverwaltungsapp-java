package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmInfoModel {

    private int film_ID;
    private String email;
    private int bewertung;
    private boolean favorit;
    private int speichermedien_id;
    private String speichermedium;


}
