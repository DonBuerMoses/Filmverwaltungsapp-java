package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db;

import com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.domain.Film;
import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Enthält alle SQL-Queries für die Filme-Tabelle
 */
public interface FilmeDao {
    @RegisterFieldMapper(Film.class)
    @SqlQuery("select * from filmverwaltungsappDB.filme a ")
    List<Film> getAllFilme();

    @RegisterFieldMapper(Film.class)
    @SqlQuery("select * from filmverwaltungsappDB.filme a where email = :email")
    List<Film> getAllFilmeOfNutzer(String email);

    @RegisterFieldMapper(Film.class)
    @SqlQuery("select * from filmverwaltungsappDB.filme where film_id = :film_ID and email = :email")
    Film getFilmById(@Bind("film_ID") int film_ID, @Bind("email") String email);

    @RegisterFieldMapper(Film.class)
    @SqlUpdate("update filmverwaltungsappDB.filme set bewertung = :bewertung and favorit = :favorit and speichermedium = :speichermedium where film_id = :film_id and email= :email")
    int updateFilm(@BindBean Film film);

    @RegisterFieldMapper(Film.class)
    @SqlUpdate("insert into filmverwaltungsappDB.filme values (:film_ID, :email, :bewertung, :favorit, :speichermedien_id)")
    int insertFilm(@BindBean Film film);

    @RegisterFieldMapper(Film.class)
    @SqlQuery("select max(a.film_id and a.email) from filmverwaltungsappDB.filme a")
    int getMaxId();

    @RegisterFieldMapper(Film.class)
    @SqlUpdate("delete from filmverwaltungsappDB.filme where film_id = :film_ID and email = :email")
    int deleteFilm(@Bind("film_ID") int film_ID, @Bind("email") String email);
}
