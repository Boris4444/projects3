package com.arvatoTestaufgabe3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FlearCalculationsTests {

	Flear f1 = new Flear("Fipps", 20.0f, 10);
	Flear f2 = new Flear("Friedolin", 200.0f, 10);
	Flear f3 = new Flear("Fury", 10.0f, 30);
	Flear f4 = new Flear("Fanta", 5.0f, 5);
	Flear f5 = new Flear("Figo", 50.0f, 70);
	Flear f6 = new Flear("Frodo", 20.0f, 25);
	
	@Test
	public void fourFlearFlow() throws Exception{
				
		List<Flear> list = new ArrayList<Flear>();
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		
		FlearCalculations fc = new FlearCalculations();
		int result = fc.getOptimalValue(50f, list);		
		System.out.println(result);
		assertEquals(45, result);
	}
	
	@Test
	public void sixFlearFlow() throws Exception{
				
		List<Flear> list = new ArrayList<Flear>();
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		list.add(f5);
		list.add(f6);
		
		FlearCalculations fc = new FlearCalculations();
		int result = fc.getOptimalValue(50f, list);		
		System.out.println(result);
		assertEquals(70, result);
	}
	
}
