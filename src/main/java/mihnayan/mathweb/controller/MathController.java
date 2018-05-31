package mihnayan.mathweb.controller;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

	@GetMapping("/")
	public String startPage() {
		return "index";
	}
	
	@GetMapping(path = "/div", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String divideNumbers(@RequestParam(value="num1", required=false) String num1,
			@RequestParam(value="num2", required=false) String num2) {
		if (num1 == null || num2 == null) {
			return buildResponse("error", "Одно из чисел не задано!");
		}
		return "Params: " + num1 + " " + num2;
	}
	
	private String buildResponse(String status, String result) {
		JsonObject json = Json.createObjectBuilder()
				.add("status", status)
				.add("result", result)
				.build();
		return json.toString();
	}
}
