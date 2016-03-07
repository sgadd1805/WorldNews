package com.news.report;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebAppConfiguration
public class FizzBuzzControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new FizzBuzzController()).build();
	}
	
	@Test
	public void validRequestFizzBuzz() throws Exception{
		mockMvc.perform(get("/api?word=fizzbuzz&max_value=10"))
		.andExpect(content().string("{\"status\":\"ok\",\"numbers\":[]}"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void validRequestBuzz() throws Exception{
		mockMvc.perform(get("/api?word=buzz&max_value=10"))
		.andExpect(content().string("{\"status\":\"ok\",\"numbers\":[5,10]}"))
		.andExpect(status().isOk());
	}

	@Test
	public void validRequestFizz() throws Exception{
		mockMvc.perform(get("/api?word=fizz&max_value=10"))
		.andExpect(content().string("{\"status\":\"ok\",\"numbers\":[3,6,9]}"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void validRequestSample() throws Exception{
		mockMvc.perform(get("/api?word=fizz&max_value=30"))
		.andExpect(content().string("{\"status\":\"ok\",\"numbers\":[3,6,9,12,15,18,21,24,27,30]}"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void invalidMax() throws Exception{
		mockMvc.perform(get("/api?word=fizz&max_value=0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void inValidInt() throws Exception{
		mockMvc.perform(get("/api?word=fizz&max_value="))
		.andExpect(content().string("{\"status\":\"error\",\"numbers\":[]}"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void inValidnegativeInt() throws Exception{
		mockMvc.perform(get("/api?word=fizz&max_value=-1"))
		.andExpect(content().string("{\"status\":\"error\",\"numbers\":[]}"))
		.andExpect(status().isBadRequest());
	}
	@Test
	public void invalidString() throws Exception{
		mockMvc.perform(get("/api?word=&max_value=10"))
		.andExpect(content().string("{\"status\":\"error\",\"numbers\":[]}"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void invalidRequest() throws Exception{
		mockMvc.perform(get("/api?word=fizzb2uzz&max_value=10"))
		.andExpect(status().isBadRequest());
	}
}
