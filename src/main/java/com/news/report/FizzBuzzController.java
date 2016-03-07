package com.news.report;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FizzBuzzController {

	
	@RequestMapping("/api")
	public ResponseEntity<FizzBuzzDTO> fizzbuzz(@RequestParam("word") String word, @RequestParam("max_value")Integer maxValue){
		FizzBuzz buzz = new FizzBuzz();
		FizzBuzzDTO buzzDTO = buzz.fizzbuzz(word, maxValue);
		return new ResponseEntity<FizzBuzzDTO>(buzzDTO, new HttpHeaders(), calculateStatus(buzzDTO));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<FizzBuzzDTO>  handleAllException(Exception ex) {
		FizzBuzzDTO buzzDTO = new FizzBuzzDTO();
		buzzDTO.setStatus("error");
		return new ResponseEntity<FizzBuzzDTO>(buzzDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	private HttpStatus calculateStatus(FizzBuzzDTO inputDTO){
		if(inputDTO.getStatus().equals("ok")){
			return HttpStatus.OK;
		}else{
			return HttpStatus.BAD_REQUEST;
		}
	}
}
