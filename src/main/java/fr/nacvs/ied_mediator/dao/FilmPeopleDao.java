package fr.nacvs.ied_mediator.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

import fr.nacvs.ied_mediator.business.FilmPeople;

public interface FilmPeopleDao {

	Iterator<FilmPeople> findByActor(String actor);
	
	Optional<FilmPeople> findByTitleAndDate(String title, LocalDate date);
}
