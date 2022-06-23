package com.gitDeveoper.Testing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class TestingApplicationTests {
Calculator calculator= new Calculator();
	@Test
	void itShouldAddTwoNumbers() {
	//conditions
		int a=3;
		int b=6;
		//implement
		int sum=calculator.add(a,b);
		//test
		int expected=9;
		assertThat(sum).isEqualTo(expected);
	}
	public class Calculator{
		public int add(int a, int b){
			return a+b;
		}
	}

}
