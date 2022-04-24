package fr.nacvs.ied_mediator.manual;

import fr.nacvs.ied_mediator.business.FilmPeople;
import fr.nacvs.ied_mediator.business.FilmSummary;
import fr.nacvs.ied_mediator.sources.film_people.FilmPeopleSparql;
import fr.nacvs.ied_mediator.sources.film_summary.FilmSummaryREST;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

public class testsources {

  public static void main(String[] args) {
    System.out.println("--> Test on FindByActor");
    FilmPeopleSparql filmPeopleSparql = new FilmPeopleSparql();
    Iterator<FilmPeople> itf = filmPeopleSparql.findByActor("Johnny Depp");
    while(itf.hasNext()){
      System.out.println(itf.next().toString());
    }
    System.out.println("--> Test on FindByNameAndDirector");
    Optional<FilmPeople> fp = filmPeopleSparql.findByTitleAndDirector("Ed Wood", "Tim Burton");
    System.out.println(fp.toString());

    System.out.println("--> Test of filmSummaryREST");
    FilmSummaryREST filmSummaryREST = new FilmSummaryREST();
    Optional<FilmSummary> fs = filmSummaryREST.findByTitleAndDate("Ed Wood", LocalDate.now());
    System.out.println(fs);

    System.out.println(LocalDate.now());

  }
}
