package fr.nacvs.ied_mediator.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RespFilmByTitle {

	private LocalDate date;
	private String genre;
	private String distributor;
	private long budget;
	private long incomeUs;
	private long incomeWorldwide;
	private String director;
	private String summary;
	private List<String> actors = new ArrayList<>(0);

	public RespFilmByTitle() {
		super();
	}

	public RespFilmByTitle(LocalDate date, String genre, String distributor, long budget, long incomeUs, long incomeWorldwide, String summary,
			List<String> actors) {
		super();
		this.date = date;
		this.genre = genre;
		this.distributor = distributor;
		this.budget = budget;
		this.incomeUs = incomeUs;
		this.incomeWorldwide = incomeWorldwide;
		this.summary = summary;
		this.actors = actors;
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

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public long getIncomeUs() {
		return incomeUs;
	}

	public void setIncomeUs(long incomeUs) {
		this.incomeUs = incomeUs;
	}

	public long getIncomeWorldwide() {
		return incomeWorldwide;
	}

	public void setIncomeWorldwide(long incomeWorldwide) {
		this.incomeWorldwide = incomeWorldwide;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}
}
