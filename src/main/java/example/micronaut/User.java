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

	String fullName;

	public User(@JsonProperty("name") String name, @JsonProperty("surname") String surname, @JsonProperty("attributes") Map<String, String> attributes) {
		this.fullName = name + " " + surname;

		final Optional<HttpRequest<Object>> httpRequest = ServerRequestContext.currentRequest();
		if (httpRequest.isEmpty()) {
			log.error("HttpRequest empty");
		} else {
			log.info("HttpRequest present");
		}
	}
}