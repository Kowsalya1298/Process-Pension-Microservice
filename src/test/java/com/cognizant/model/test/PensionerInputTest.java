package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionerInput;

@SpringBootTest
public class PensionerInputTest {

	PensionerInput pensionerInput = new PensionerInput();

	@Test
	public void PensionerDetailBeanTest() {
		assertNotNull(pensionerInput);
	}

	@Test
	public void PensionerInputNoArgConstructorTest() {
		PensionerInput pensionerInput1 = new PensionerInput();
		assertThat(assertThat(pensionerInput1).isNotNull());
	}

	@Test
	public void PensionerInputAllArgConstructorTest() {
		PensionerInput pensionerInput1 = new PensionerInput("1234567654678");
		assertNotNull(pensionerInput1);
	}

	@Test
	public void PensionerDetailSettersTest() {
		PensionerInput pensionerDetail1 = new PensionerInput();
		pensionerDetail1.setAadhaarNumber("1211121324343543");
		assertNotNull(pensionerDetail1);

	}

}
