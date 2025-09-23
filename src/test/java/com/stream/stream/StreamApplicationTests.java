package com.stream.stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StreamApplicationTests {
public	StreamApplication mockApp = Mockito.mock(StreamApplication.class);

	@Test
	void contextLoads() {
	}

	@Test
	 void TestReturnAmount(){
		int result=1;
when(mockApp.returnAmount(1)).thenReturn(result);

assertEquals(1,result);



	}
}
