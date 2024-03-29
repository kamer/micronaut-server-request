package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.Media;

@Controller("/demo")
public class DemoController {

	private static final Logger log = LoggerFactory.getLogger(DemoController.class);

	@Post
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HttpResponse<User> demo(@Body User user) {
		log.info("User {} received.", user.fullName);
		return HttpResponse.ok();
	}
}