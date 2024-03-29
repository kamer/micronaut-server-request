package example.micronaut;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.context.ServerRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Introspected
public record User(String fullName) {

	private static final Logger log = LoggerFactory.getLogger(User.class);

	@JsonCreator
	public User(@JsonProperty("name") String name, @JsonProperty("surname") String surname) {
		this(name + " " + surname);

		final Optional<HttpRequest<Object>> httpRequest = ServerRequestContext.currentRequest();
		if (httpRequest.isEmpty()) {
			throw new RuntimeException("HttpRequest empty");
		} else {
			log.info("Request is present");
		}
	}
}