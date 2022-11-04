package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.db;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.spring5.JdbiFactoryBean;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * Konfiguriert Datenbankverbindung mit Einstellungen in den properties;
 * Definiert Dao Beans
 */
@Configuration
public class DatabaseConfiguration {

    /**
     * instanziert eine neue JdbiFactoryBean mit den Datenbankeinstellungen von den Properties und gibt jdbiFactoryBean zurück.
     * @param dataSource
     * @return
     */
    @Bean
    public JdbiFactoryBean jdbiFactoryBean(DataSource dataSource){
        JdbiFactoryBean jdbiFactoryBean = new JdbiFactoryBean(dataSource);

        // sqlobject-Plugin registrieren
        jdbiFactoryBean.setPlugins(Collections.singletonList(new SqlObjectPlugin()));

        return jdbiFactoryBean;
    }

    @Bean
    public FilmeDao filmeDao(Jdbi jdbi) {
        return jdbi.onDemand(FilmeDao.class);
    }

    @Bean
    public SpeichermedienDao speichermedienDao(Jdbi jdbi) {
        return jdbi.onDemand(SpeichermedienDao.class);
    }

    @Bean
    public NutzerDao nutzerDao(Jdbi jdbi) {
        return jdbi.onDemand(NutzerDao.class);
    }
}
