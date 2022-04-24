package fr.nacvs.ied_mediator.sources.film_summary;


import com.mysql.cj.result.LocalDateValueFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.nacvs.ied_mediator.business.FilmSummary;
import fr.nacvs.ied_mediator.dao.FilmSummaryDao;
import fr.nacvs.ied_mediator.sources.film_people.FilmPeopleSparql;
import fr.nacvs.ied_mediator.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.Optional;
import javax.xml.namespace.QName;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class FilmSummaryREST implements FilmSummaryDao {

  private static Logger LOGGER = LoggerFactory.getLogger(FilmPeopleSparql.class);
  private static String APIKEY = "62cb014b";

  @Override
  public Optional<FilmSummary> findByTitleAndDate(String title, LocalDate date)  {
    title = title.replaceAll("\\ ", "+");

    final ClientConfig clientConfig = new DefaultClientConfig();
    final Client client = Client.create(clientConfig);
    final WebResource webResource = client.resource(UriBuilder.fromUri("http://www.omdbapi.com/?i=tt3896198&apikey="+APIKEY+"&r=xml&t=+"+title+"&y=1994&plot=full").build());
    String resp = webResource.accept(MediaType.APPLICATION_XML).get(String.class);
    System.out.println(resp);

    String xPathdate = (String) XPath(resp, "/root/movie/@released", XPathConstants.STRING);
    String director = (String) XPath(resp, "/root/movie/@director", XPathConstants.STRING);
    String xpathTitle = (String) XPath(resp, "/root/movie/@title", XPathConstants.STRING);
    String plot = (String) XPath(resp, "/root/movie/@plot", XPathConstants.STRING);

    FilmSummary filmSummary = new FilmSummary();
    filmSummary.setDirector(director);
    filmSummary.setTitle(xpathTitle);
    filmSummary.setSummary(plot);
    //todo correct the conversion to localDate
    //System.out.println(xPathdate + "-->  "+DateUtils.toDateFromOMD(xPathdate));
    //filmSummary.setDate(DateUtils.toDateFromOMD(xPathdate));
    if(filmSummary.getTitle().contentEquals("")){
      return Optional.empty();
    }
    return Optional.of(filmSummary);
  }

  @Override
  public Optional<FilmSummary> findByTitleAndDirector(String title, String director) {
    title = title.replaceAll("\\ ", "+");

    final ClientConfig clientConfig = new DefaultClientConfig();
    final Client client = Client.create(clientConfig);
    final WebResource webResource = client.resource(UriBuilder.fromUri("http://www.omdbapi.com/?i=tt3896198&apikey="+APIKEY+"&r=xml&t=+"+title+"&y=1994&plot=full").build());
    String resp = webResource.accept(MediaType.APPLICATION_XML).get(String.class);
    System.out.println(resp);

    String date = (String) XPath(resp, "/root/movie/@released", XPathConstants.STRING);
    String xpathdirector = (String) XPath(resp, "/root/movie/@director", XPathConstants.STRING);
    String xpathTitle = (String) XPath(resp, "/root/movie/@title", XPathConstants.STRING);
    String plot = (String) XPath(resp, "/root/movie/@plot", XPathConstants.STRING);

    FilmSummary filmSummary = new FilmSummary();
    filmSummary.setDirector(director);
    filmSummary.setTitle(xpathTitle);
    filmSummary.setSummary(plot);

    if(filmSummary.getTitle().contentEquals("")){
      return Optional.empty();
    }
    return Optional.of(filmSummary);
  }

  private static Object XPath(String uri, String requete, QName typeRetour){
    //Le dernier paramètre indique le type de résultat souhaité
    //XPathConstants.STRING: chaîne de caractères (String)
    //XPathConstants.NODESET: ensemble de noeuds DOM (NodeList)
    //XPathConstants.NODE: noeud DOM (Node) - le premier de la liste
    //XPathConstants.BOOLEAN: booléen (Boolean) - vrai si la liste n'est pas vide
    //XPathConstants.NUMBER: numérique (Double) - le contenu du noeud sélectionné transformé en Double

    try{
      //Transformation en document DOM du contenu XML
      DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
      DocumentBuilder parseur = fabrique.newDocumentBuilder();
      Document document = parseur.parse(new InputSource(new StringReader(uri)));

      //création de l'objet XPath
      XPathFactory xfabrique = XPathFactory.newInstance();
      XPath xpath = xfabrique.newXPath();

      //évaluation de l'expression XPath
      XPathExpression exp = xpath.compile(requete);
      return exp.evaluate(document, typeRetour);

    } catch(Exception e){
      System.out.println("error : "+e.getMessage());
    }
    return null;
  }


}
