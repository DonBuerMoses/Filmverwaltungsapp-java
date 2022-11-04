package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Definiert die Attribute für die Filme-JSON
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    private int film_ID;
    private String email;
    private int bewertung;
    private boolean favorit;
    private int speichermedien_id;

}
