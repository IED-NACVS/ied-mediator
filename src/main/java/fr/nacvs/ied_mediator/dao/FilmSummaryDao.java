package fr.nacvs.ied_mediator.dao;

import java.util.Iterator;

import fr.nacvs.ied_mediator.business.FilmSummary;

public interface FilmSummaryDao {

	Iterator<FilmSummary> findByTitle(String title);
}
