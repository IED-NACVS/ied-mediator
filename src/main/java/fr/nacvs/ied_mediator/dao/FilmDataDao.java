package fr.nacvs.ied_mediator.dao;

import java.time.LocalDate;
import java.util.Iterator;

import fr.nacvs.ied_mediator.business.FilmData;

public interface FilmDataDao {

	Iterator<FilmData> findByTitle(String title);
	
	FilmData findByTitleAndDate(String title, LocalDate date);
}
