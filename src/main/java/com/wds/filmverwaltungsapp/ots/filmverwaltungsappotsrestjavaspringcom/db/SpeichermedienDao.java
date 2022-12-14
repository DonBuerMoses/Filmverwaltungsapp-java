package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Speichermedium;
import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Enthält alle SQL-Queries für die Speichermedien-Tabelle
 */
public interface SpeichermedienDao {

    @RegisterFieldMapper(Speichermedium.class)
    @SqlQuery("select * from filmverwaltungsappDB.speichermedien a")
    List<Speichermedium> getAllSpeichermedien();

    @RegisterFieldMapper(Speichermedium.class)
    @SqlQuery("select * from filmverwaltungsappDB.speichermedien where speichermedien_id = :speichermedien_id")
    Speichermedium getSpeichermediumById(@Bind("speichermedien_id") int speichermedien_id);

    @RegisterFieldMapper(Speichermedium.class)
    @SqlUpdate("update filmverwaltungsappDB.speichermedien set bezeichnung = :bezeichnung where speichermedien_id = :speichermedien_id")
    int updateSpeichermedium(@BindBean Speichermedium speichermedium);

    @RegisterFieldMapper(Speichermedium.class)
    @SqlUpdate("insert into filmverwaltungsappDB.speichermedien(bezeichnung) values (:bezeichnung)")
    int insertSpeichermedium(@BindBean Speichermedium speichermedium);

    @RegisterFieldMapper(Speichermedium.class)
    @SqlQuery("select max(a.speichermedien_id) from filmverwaltungsappDB.speichermedien a")
    int getMaxId();

    @RegisterFieldMapper(Speichermedium.class)
    @SqlUpdate("delete from filmverwaltungsappDB.speichermedien where speichermedien_id = :speichermedien_id")
    int deleteSpeichermedium(@Bind("speichermedien_id") int speichermedien_id);
}
