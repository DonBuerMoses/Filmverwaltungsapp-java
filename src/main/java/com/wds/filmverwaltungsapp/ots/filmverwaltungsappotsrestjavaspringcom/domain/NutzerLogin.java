package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutzerLogin {
    private String name;
    private String passwort;
}
