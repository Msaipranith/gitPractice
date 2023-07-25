package redoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "hello world";
	}
	
}