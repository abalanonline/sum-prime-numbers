package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeNumbersApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testSimpleApi() throws Exception {
    // I googled "sum of prime numbers from 1 to 100" and it replied 1060, will use it as a test
    this.mockMvc.perform(get("/sum-primes/till/1000"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("1060"));
  }

}
