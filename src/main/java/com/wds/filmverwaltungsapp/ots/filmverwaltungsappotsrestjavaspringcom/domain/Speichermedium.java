package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Definiert die Attribute für die Speichermedien-JSON
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speichermedium {

    private int speichermedien_ID;
    private String bezeichnung;

}
