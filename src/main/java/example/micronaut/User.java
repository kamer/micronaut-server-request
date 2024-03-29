package example.micronaut;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.serde.annotation.Serdeable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

@Serdeable
@Introspected
public class User {

	private static final Logger log = LoggerFactory.getLogger(User.class);

	String name;
	String surname;
	Map<String, String> attributes;
	String[] whitelist;

	public User(String name, String surname, Map<String, String> attributes, String[] whitelist) {
		this.name = name;
		this.surname = surname;
		this.attributes = attributes;
		this.whitelist = whitelist;

		final Optional<HttpRequest<Object>> httpRequest = ServerRequestContext.currentRequest();
		if (httpRequest.isEmpty()) {
			log.error("HttpRequest empty");
		} else {
			log.info("HttpRequest present");
		}
	}
}