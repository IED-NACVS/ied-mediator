package fr.nacvs.ied_mediator.dao;

import java.time.LocalDate;

import fr.nacvs.ied_mediator.business.FilmSummary;

public interface FilmSummaryDao {

	FilmSummary findByTitleAndDate(String title, LocalDate date);
}
