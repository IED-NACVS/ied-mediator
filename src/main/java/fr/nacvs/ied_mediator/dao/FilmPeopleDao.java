package fr.nacvs.ied_mediator.dao;

import java.time.LocalDate;
import java.util.Iterator;

import fr.nacvs.ied_mediator.business.FilmData;
import fr.nacvs.ied_mediator.business.FilmPeople;

public interface FilmPeopleDao {

	Iterator<FilmPeople> findByActor(String actor);
	
	FilmPeople findByTitleAndDate(String title, LocalDate date);
}
