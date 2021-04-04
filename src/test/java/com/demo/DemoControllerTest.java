package com.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = DemoController.class)
public class DemoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void cdaas() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(content().string(containsString("Demo App")));
	}

	@Test
	public void gitlab() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(content().string(containsString("GitLab")));
	}

	@Test
	public void artifactory() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(content().string(containsString("Artifactory")));
	}

	@Test
	public void pgadmin() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(content().string(containsString("PG Admin")));
	}

	@Test
	public void adminer() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(content().string(containsString("Adminer")));
	}

}
