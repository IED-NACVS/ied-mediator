package fr.nacvs.ied_mediator.api.response_writer;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.nacvs.ied_mediator.api.responses.film_by_title.RespFilmsByTitle;
import fr.nacvs.ied_mediator.api.responses.film_of_actor.RespFilmsOfActor;

public class JsonResponseWriter implements ResponseWriter {
	
	private ObjectMapper objectMapper = new ObjectMapper();

	public JsonResponseWriter() {
		super();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(new JavaTimeModule());
	}

	@Override
	public void write(RespFilmsOfActor response, Writer writer) throws IOException {
		objectMapper.writeValue(writer, response);
	}

	@Override
	public void write(RespFilmsByTitle response, Writer writer) throws IOException {
		objectMapper.writeValue(writer, response);
	}

	@Override
	public String renameFilename(String filename) {
		return FilenameUtils.removeExtension(filename) + ".json";
	}

}
