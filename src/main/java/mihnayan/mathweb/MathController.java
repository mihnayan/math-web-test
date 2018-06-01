package mihnayan.mathweb;

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
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		double number1, number2;
		try {
			number1 = Double.parseDouble(num1);
			number2 = Double.parseDouble(num2);
		} catch(NullPointerException e) {
			return buildResponse("error", "Одно из чисел не задано!");
		} catch(NumberFormatException e) {
			return buildResponse("error", "Не возможно преобразовать в число одно из значений!");
		}
		
		Double result = number1/number2;
		
		return buildResponse("ok", result.toString());
	}
	
	private String buildResponse(String status, String result) {
		JsonObject json = Json.createObjectBuilder()
				.add("status", status)
				.add("result", result)
				.build();
		return json.toString();
	}
}
