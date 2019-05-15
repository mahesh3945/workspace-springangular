package com.example.demogradle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRestControllerTest {
	@InjectMocks
	private SpringRestController springRestController;
	
	@Test
	public void readNameTest() {		
		
		String unexpected="getNamemethod";		
		String actual=springRestController.readName();		
		assertNotEquals(unexpected, actual);
	}
	@Test
	public void readNameXmlTest() {
		
		String expected="<clients>\n<clientid>11</clientid>\n<clientname>mahesh</clientname>\n</clients>";
		String actual= springRestController.readNameXml("11","mahesh");
		
		assertEquals(expected, actual);
	}
	@Test
	public void readNameJson() {
		DemoRest expected =new DemoRest();
		expected.setEmpNo(11);
		expected.setEmpName("mahesh");
		expected.setEmpSal(5000);
		DemoRest actual=springRestController.readNameJson();
		System.out.println(actual.getEmpNo()+actual.getEmpName()+actual.getEmpSal());
		assertEquals(expected.getEmpNo(), actual.getEmpNo());
	}
}





















