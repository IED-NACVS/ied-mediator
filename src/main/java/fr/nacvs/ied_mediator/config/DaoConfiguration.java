package fr.nacvs.ied_mediator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.nacvs.ied_mediator.dao.FilmDataDao;
import fr.nacvs.ied_mediator.sources.film_data.FilmDataJdbcSource;

@Configuration
public class DaoConfiguration {

	@Bean
	public FilmDataDao filmDataDao(FilmDataSourceProperties properties) {
		return new FilmDataJdbcSource(properties);
	}
}
