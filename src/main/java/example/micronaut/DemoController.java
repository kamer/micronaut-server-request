package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.print.attribute.standard.Media;

@Controller("/demo")
public class DemoController {

	@Post
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HttpResponse<User> demo(@Body User user) {
		return HttpResponse.ok(user);
	}
}