package fr.nacvs.ied_mediator.business;

import java.time.LocalDate;

public class FilmSummary {

	private String title;
	private LocalDate date;
	private String summary;

	public FilmSummary() {
		super();
	}

	public FilmSummary(String title, LocalDate date, String summary) {
		super();
		this.title = title;
		this.date = date;
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
