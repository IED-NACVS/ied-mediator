package fr.nacvs.ied_mediator.config;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.nacvs.ied_mediator.business.FilmSummary;
import fr.nacvs.ied_mediator.dao.FilmDataDao;
import fr.nacvs.ied_mediator.dao.FilmPeopleDao;
import fr.nacvs.ied_mediator.dao.FilmSummaryDao;
import fr.nacvs.ied_mediator.sources.film_data.FilmDataJdbcSource;
import fr.nacvs.ied_mediator.sources.film_people.FilmPeopleSparql;

@Configuration
public class DaoConfiguration {

	@Bean
	public FilmDataDao filmDataDao(FilmDataSourceProperties properties) {
		return new FilmDataJdbcSource(properties);
	}
	
	@Bean
	public FilmPeopleDao filmPeopleDao() {
		return new FilmPeopleSparql();
	}
	
	@Bean
	public FilmSummaryDao filmSummaryDao() {
		// TODO : temporary, remove this
		return new FilmSummaryDao() {
			
			@Override
			public Optional<FilmSummary> findByTitleAndDirector(String title, String director) {
				return Optional.empty();
			}
			
			@Override
			public Optional<FilmSummary> findByTitleAndDate(String title, LocalDate date) {
				return Optional.empty();
			}
		};
	}
}
