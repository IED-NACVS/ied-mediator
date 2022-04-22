package fr.nacvs.ied_mediator.dao;

import java.util.Iterator;
import java.util.Optional;

import fr.nacvs.ied_mediator.business.FilmPeople;

public interface FilmPeopleDao {

	Iterator<FilmPeople> findByActor(String actor);
	
	Optional<FilmPeople> findByTitleAndDistributor(String title, String distributor);
}
