package fr.nacvs.ied_mediator.manual;

import java.time.LocalDate;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.nacvs.ied_mediator.sources.film_summary.XmlHelper;
import fr.nacvs.ied_mediator.util.DateUtils;

public class XPathTest {

	public static void main(String[] args) {
		XmlHelper helper = new XmlHelper();

//		testErrorResponse(helper);
//		testValidResponse(helper);
		testDetailsResponse(helper);
	}

	private static void testErrorResponse(XmlHelper helper) {
		Document xml = helper.loadXml("<root response=\"False\"><error>Movie not found!</error></root>");
		// Check response value
		System.out.println(helper.anyMatch(xml, "/root[@response = 'True']"));
		System.out.println(Boolean.parseBoolean(helper.findString(xml, "/root/@response")));
		System.out.println(helper.findBoolean(xml, "/root/@response"));
		// Get error message
		System.out.println(helper.findString(xml, "/root/error"));
	}

	private static void testValidResponse(XmlHelper helper) {
		// Find result count
		Document response = helper.loadXml("<root totalResults=\"48\" response=\"True\">\r\n" +
				"<result title=\"The Avengers\" year=\"2012\" imdbID=\"tt0848228\" type=\"movie\" poster=\"https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"The Avengers\" year=\"1998\" imdbID=\"tt0118661\" type=\"movie\" poster=\"https://m.media-amazon.com/images/M/MV5BYWE1NTdjOWQtYTQ2Ny00Nzc5LWExYzMtNmRlOThmOTE2N2I4XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"The Avengers: Earth's Mightiest Heroes\" year=\"2010–2012\" imdbID=\"tt1626038\" type=\"series\" poster=\"https://m.media-amazon.com/images/M/MV5BYzA4ZjVhYzctZmI0NC00ZmIxLWFmYTgtOGIxMDYxODhmMGQ2XkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"Ultimate Avengers: The Movie\" year=\"2006\" imdbID=\"tt0491703\" type=\"movie\" poster=\"https://m.media-amazon.com/images/M/MV5BMTYyMjk0NTMwMl5BMl5BanBnXkFtZTgwNzY0NjAwNzE@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"The Avengers\" year=\"1961–1969\" imdbID=\"tt0054518\" type=\"series\" poster=\"https://m.media-amazon.com/images/M/MV5BZWQwZTdjMDUtNTY1YS00MDI0LWFkNjYtZDA4MDdmZjdlMDRlXkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"The New Avengers\" year=\"1976–1977\" imdbID=\"tt0074031\" type=\"series\" poster=\"https://m.media-amazon.com/images/M/MV5BMTIwNDg4NzE1N15BMl5BanBnXkFtZTcwNTIwMDYyMQ@@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"The Avengers\" year=\"1942\" imdbID=\"tt0034639\" type=\"movie\" poster=\"https://m.media-amazon.com/images/M/MV5BODY2NWFjZTUtNTU2Ni00NWU5LTgwNDItMTQwYzdhYTFhMzlhXkEyXkFqcGdeQXVyMDY4MzkyNw@@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"Marvel Disk Wars: The Avengers\" year=\"2014–2015\" imdbID=\"tt3644256\" type=\"series\" poster=\"https://m.media-amazon.com/images/M/MV5BNDZmYjNmYTktNDVjMi00N2I0LWI0MjEtNzEyYzYzZjU5MGEwXkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"The Shaolin Avengers\" year=\"1976\" imdbID=\"tt0074513\" type=\"movie\" poster=\"https://m.media-amazon.com/images/M/MV5BMzc3NWViYjktNDEwMy00NTY2LTkyMTMtMDZjYzUxMGRhYjg1XkEyXkFqcGdeQXVyNjUzNzQ4NDQ@._V1_SX300.jpg\"/>\r\n"
				+
				"<result title=\"Captain America and the Avengers\" year=\"1991\" imdbID=\"tt0421939\" type=\"game\" poster=\"https://m.media-amazon.com/images/M/MV5BZDhiN2JlMTUtZTZjZS00ODM3LWE1YmYtYjk2MTkxZmNhNGYxXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_SX300.jpg\"/>\r\n"
				+
				"</root>");

		// Find total results count
		double totalResults = helper.findDouble(response, "/root/@totalResults");
		System.out.println("Total results = " + totalResults);
		// Find all nodes with precise title
		NodeList nodeList = helper.findNodeList(response, "/root/result[@title = 'The Avengers']");
		for (int index = 0; index < nodeList.getLength(); index++) {
			Node node = nodeList.item(index);
			System.out.println(node.getAttributes().getNamedItem("imdbID").getNodeValue());
		}
	}

	private static void testDetailsResponse(XmlHelper helper) {
		Document response = helper.loadXml("<root response=\"True\">\r\n"
				+ "<movie title=\"The Matrix\" year=\"1999\" rated=\"R\" released=\"31 Mar 1999\" runtime=\"136 min\" genre=\"Action, Sci-Fi\" director=\"Lana Wachowski, Lilly Wachowski\" writer=\"Lilly Wachowski, Lana Wachowski\" actors=\"Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss\" plot=\"Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. As a rebel against the machines, Neo must confront the agents: super-powerful computer programs devoted to stopping Neo and the entire human rebellion.\" language=\"English\" country=\"United States, Australia\" awards=\"Won 4 Oscars. 42 wins 51 nominations total\" poster=\"https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\" metascore=\"73\" imdbRating=\"8.7\" imdbVotes=\"1,851,767\" imdbID=\"tt0133093\" type=\"movie\"/>\r\n"
				+ "</root>");
		// Find release date
		String dateStr = helper.findString(response, "/root/movie/@released");
		LocalDate date = DateUtils.toDateShortMonth(dateStr);
		System.out.println(DateUtils.toString(date));
		// Find director
		String director = helper.findString(response, "/root/movie/@director");
		System.out.println(director);
	}
}
