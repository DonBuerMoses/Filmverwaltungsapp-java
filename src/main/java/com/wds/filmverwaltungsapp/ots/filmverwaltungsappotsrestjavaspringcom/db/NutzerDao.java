package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Nutzer;
import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

/**
 * Enthält alle SQL-Queries für die Nutzer-Tabelle
 */
public interface NutzerDao {

    @RegisterFieldMapper(Nutzer.class)
    @SqlQuery("select * from filmverwaltungsappDB.nutzer a ")
    List<Nutzer> getAllNutzer();
}
