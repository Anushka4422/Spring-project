package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	// http://localHost:4747/pqr

	@RequestMapping("/")
	public String sayHello() {
		return "<h2> Welcome to Spring Boot pqr </h2>";
	}

	@RequestMapping("/pqr")
	public String sayHello2() {
		return "<h2> new demos </h5>";

	}

}
