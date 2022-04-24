package fr.nacvs.ied_mediator.api.responses.film_of_actor;

import java.time.LocalDate;
import java.util.List;

import fr.nacvs.ied_mediator.business.FilmData;
import fr.nacvs.ied_mediator.business.FilmPeople;

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
	
	public void fillDataInfos(FilmData data) {
		this.title = data.getTitle();
		this.date = data.getDate();
		this.genre = data.getGenre();
		this.distributor = data.getDistributor();
	}
	
	public void fillPeopleInfos(FilmPeople people) {
		this.title = people.getTitle();
		this.date = people.getDate();
		this.producers = people.getProducers();
		this.director = people.getDirector();
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

	@Override
	public String toString() {
		return "RespOneFilmOfActor [title=" + title + ", date=" + date + ", genre=" + genre + ", distributor=" + distributor + ", director=" + director
				+ ", producers=" + producers + "]";
	}
}
