package fr.nacvs.ied_mediator.api;

import java.time.LocalDate;
import java.util.List;

public class RespOneFilmOfActor {
	private String title;
	private LocalDate date;
	private String genre;
	private String distributor;
	private String director;
	private List<String> producers;

	public RespOneFilmOfActor() {
		super();
	}

	public RespOneFilmOfActor(String title, LocalDate date, String genre, String distributor, String director, List<String> producers) {
		super();
		this.title = title;
		this.date = date;
		this.genre = genre;
		this.distributor = distributor;
		this.director = director;
		this.producers = producers;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getProducers() {
		return producers;
	}

	public void setProducers(List<String> producers) {
		this.producers = producers;
	}
}
