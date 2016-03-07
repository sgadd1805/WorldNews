package com.news.report;


public class FizzBuzz {



	public FizzBuzzDTO fizzbuzz(String inputString, Integer maxValue){
		FizzBuzzDTO buzzDTO = new FizzBuzzDTO();
		if(validateWord(inputString) > 0 && validateMaxValue(maxValue)){
			buzzDTO.setStatus("ok");
			return calculateFizzBuzz(inputString, maxValue, buzzDTO);
		}else{
			buzzDTO.setStatus("error");
			return buzzDTO;
		}
	}

	private FizzBuzzDTO calculateFizzBuzz(String inputString, Integer maxValue, FizzBuzzDTO fizzDTO){
		Integer count = 1;
		Integer remainder = 0;
		while(count <= maxValue){
			if(inputString.equalsIgnoreCase("fizz")){
				remainder = (count % 3);
				if(remainder ==  0){
					fizzDTO.setNumbers(count);
				}
			}
			else if(inputString.equalsIgnoreCase("buzz")){
				remainder = (count % 5);
				if(remainder ==  0){
					fizzDTO.setNumbers(count);
				}
			}
			else if(inputString.equalsIgnoreCase("fizzbuzz")){
				remainder = (count % 3);
				if(remainder ==  0){
					if(count % 5 ==  0){
						fizzDTO.setNumbers(count);
					}
				}
			}
			count++;

		}
		return fizzDTO;
	}

	private boolean validateMaxValue(Integer maxValue){
		if(maxValue > 0){
			return true;
		}else
			return false;
	}

	private static int validateWord(String inputString){
		try{
			return WordEnum.valueOf(inputString.toLowerCase()).getWordCode();
		}catch(Exception e){
			return 0;
		}

	}
}
