package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Definiert die Attribute für die Nutzer-JSON
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nutzer {
    private String email;
    private String name;
    private String passwort;
}
