package fr.nacvs.ied_mediator.manual;

import fr.nacvs.ied_mediator.sources.film_people.FilmPeopleSparql;

public class testsources {

  public static void main(String[] args) {
    FilmPeopleSparql filmPeopleSparql = new FilmPeopleSparql();
    filmPeopleSparql.findByActor("Johnny Depp");
  }
}
