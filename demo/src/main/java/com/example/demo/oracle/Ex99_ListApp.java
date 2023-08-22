package com.example.demo.oracle;

import java.util.ArrayList;
import java.util.List;

public class Ex99_ListApp {

	public static void main(String[] args) {
		// 방법 1
		Customer c1 = new Customer();
		c1.setCustId(101);
		c1.setName("박찬호");
		c1.setAddr("미국 엘에이");
		c1.setPhone("010-6666-7777");
		
		// 방법 2
		Customer c2 = new Customer(102, "박인비", "대한민국 서울", "010-2223-1004");
		
		//System.out.println(c1);
		//System.out.println(c2);
		
		List<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		
		// print 방법 1
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println();
		
		// print 방법 2
		for (Customer c : list) {
			System.out.println(c);
		}
		System.out.println();
		
		// print 방법 3
		list.forEach(x -> System.out.println(x));
	}
}
