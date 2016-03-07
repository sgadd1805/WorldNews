package com.news.report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class FizzBuzzTest {
	
	@Test
	public void fizzTest(){
		FizzBuzz testObject = new FizzBuzz();
		FizzBuzzDTO buzzDTO = testObject.fizzbuzz("fizz", 10);
		assertEquals("ok",buzzDTO.getStatus());
		assertEquals(3,buzzDTO.getNumbers().size());
		assertTrue(detechDuplicates(buzzDTO.getNumbers()));
	}

	@Test
	public void buzzzTest(){
		FizzBuzz testObject = new FizzBuzz();
		FizzBuzzDTO buzzDTO = testObject.fizzbuzz("buzz", 20);
		assertEquals("ok",buzzDTO.getStatus());
		assertEquals(4,buzzDTO.getNumbers().size());
		assertTrue(detechDuplicates(buzzDTO.getNumbers()));
	}
	
	@Test
	public void fizzbuzzzTest(){
		FizzBuzz testObject = new FizzBuzz();
		FizzBuzzDTO buzzDTO = testObject.fizzbuzz("fizzbuzz", 30);
		assertEquals("ok",buzzDTO.getStatus());
		assertEquals(2,buzzDTO.getNumbers().size());
		assertTrue(detechDuplicates(buzzDTO.getNumbers()));
	}
	
	@Test
	public void buzzzCapitalTest(){
		FizzBuzz testObject = new FizzBuzz();
		FizzBuzzDTO buzzDTO = testObject.fizzbuzz("BUZZ", 20);
		assertEquals("ok",buzzDTO.getStatus());
		assertEquals(4,buzzDTO.getNumbers().size());
		assertTrue(detechDuplicates(buzzDTO.getNumbers()));
		assertTrue(detechDuplicates(buzzDTO.getNumbers()));
	}
	
	@Test
	public void errorTest(){
		FizzBuzz testObject = new FizzBuzz();
		FizzBuzzDTO buzzDTO = testObject.fizzbuzz("fake", 10);
		assertEquals("error",buzzDTO.getStatus());
		assertEquals(0,buzzDTO.getNumbers().size());
		assertTrue(detechDuplicates(buzzDTO.getNumbers()));
	}
	
	private boolean detechDuplicates(ArrayList<Integer> inputList){
			for(int i = 1; i < inputList.size(); i++){
				if(inputList.get(i-1) >= inputList.get(i)){
					return false;
				}
			}
			return true;
		
	}
}
