package fr.nacvs.ied_mediator.dao;

import java.util.Iterator;

import fr.nacvs.ied_mediator.business.FilmPeople;

public interface FilmPeopleDao {

	Iterator<FilmPeople> findByActor(String actor);
	
	Iterator<FilmPeople> findByTitle(String title);
}
