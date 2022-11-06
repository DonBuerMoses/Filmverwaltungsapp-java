package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Nutzer;
import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Enthält alle SQL-Queries für die Nutzer-Tabelle
 */
public interface NutzerDao {

    @RegisterFieldMapper(Nutzer.class)
    @SqlQuery("select * from filmverwaltungsappDB.nutzer a ")
    List<Nutzer> getAllNutzer();

    @RegisterFieldMapper(Nutzer.class)
    @SqlQuery("select * from filmverwaltungsappDB.nutzer a where a.name = :name and a.passwort = :passwort")
    Nutzer getNutzerByNameAndPasswort(@Bind("name") String name, @Bind("passwort") String passwort);

    @RegisterFieldMapper(Nutzer.class)
    @SqlQuery("select email from filmverwaltungsappDB.nutzer where name = :name and passwort = :passwort")
    String getEmailofNutzerByNameAndPasswort(@Bind("name") String name, @Bind("passwort") String passwort);

    @RegisterFieldMapper(Nutzer.class)
    @SqlUpdate("insert into filmverwaltungsappDB.nutzer values (:email, :name, :passwort)")
    int insertNutzer(@BindBean Nutzer nutzer);
}
