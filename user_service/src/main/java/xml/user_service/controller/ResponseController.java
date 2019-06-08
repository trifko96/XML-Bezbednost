package xml.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
public class ResponseController {

	@GetMapping(value = "/getResponse")
	public String getResponse() {
		return "hello";
	}
	
}
