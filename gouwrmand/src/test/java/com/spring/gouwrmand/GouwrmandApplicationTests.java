package com.spring.gouwrmand;

import com.spring.gouwrmand.controllers.HomeController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
class GouwrmandApplicationTests {

	@Autowired
	private HomeController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		System.out.println("Testing...");
		assertThat(controller).isNotNull();
	}

	@Test
	void TestServerRunning() throws Exception{
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void TestHomePage() throws Exception{
		this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void TestLoginPage() throws Exception{
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}

}
