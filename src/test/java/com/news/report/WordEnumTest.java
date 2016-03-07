package com.news.report;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordEnumTest {

	
	@Test
	public void getValidTest(){
		 assertEquals("fizz",WordEnum.fizz.toString());
		 assertEquals("buzz", WordEnum.buzz.toString());
		 assertEquals("fizzbuzz", WordEnum.fizzbuzz.toString());
	}
	
	@Test
	public void getEnumValue(){
		 assertEquals(3, WordEnum.fizz.getWordCode());
		 assertEquals(5, WordEnum.buzz.getWordCode());
		 assertEquals(5, WordEnum.fizzbuzz.getWordCode());
	}
	
	
}
