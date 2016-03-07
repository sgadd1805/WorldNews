package com.news.report;

import java.util.ArrayList;

public class FizzBuzzDTO {
	
	private String status;
	private ArrayList<Integer> numbers;
	
	public FizzBuzzDTO(){
		this.numbers = new ArrayList<Integer>();
	}
	
	public FizzBuzzDTO(ArrayList<Integer> numbers) {
		super();
		this.numbers = numbers;
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer number) {
		numbers.add(number);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
