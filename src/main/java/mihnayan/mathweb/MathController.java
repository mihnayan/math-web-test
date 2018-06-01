package mihnayan.mathweb;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

	@GetMapping("/")
	public String startPage() {
		return "index";
	}
	
	@PostMapping(path = "/div", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String divideNumbers(@RequestParam(value="num1", required=false) String num1,
			@RequestParam(value="num2", required=false) String num2) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		double number1, number2;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		try {
			number1 = Double.parseDouble(num1);
			number2 = Double.parseDouble(num2);
		} catch(NullPointerException e) {
			return buildErrorResponse(jsonBuilder, "Одно из чисел не задано!");
		} catch(NumberFormatException e) {
			return buildErrorResponse(jsonBuilder, "Не возможно преобразовать в число одно из значений!");
		}
		
		Double result = number1/number2;
		
		jsonBuilder
			.add("status", "ok")
			.add("num1", num1)
			.add("num2", num2)
			.add("result", result.toString());
		
		return jsonBuilder.build().toString();
	}
	
	private String buildErrorResponse (JsonObjectBuilder jsonBuilder, String text) {
		return jsonBuilder
				.add("status", "error")
				.add("result",  text)
				.build().toString();
	}
	
}
