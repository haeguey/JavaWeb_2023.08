package com.example.demo.oracle;

import java.util.List;

public class Ex11_CustomerTest {

	public static void main(String[] args) {
		CustomerDao cDao = new CustomerDao();
		
		// custId 값으로 검색해서 Customer 객체를 구해서 출력
		// Customer c1 = cDao.getCustomer(6);
		// System.out.println(c1);
		
		// cDao.insertCustomer(Customer c)
//		Customer c3 = new Customer(8, "김민재", "독일 뮌헨", "010-8888-7777");
//		cDao.insertCustomer(c3);
		
		// cDao.updateCustomer(Customer c)
//		Customer c4 = cDao.getCustomer(8);
//		c4.setPhone("010-3456-9876");
//		c4.setName("김영구");
//		c4.setAddr("북한 평양");
//		cDao.updateCustomer(c4);
		
		// cDao.deleteCustomer(int custId)
//		cDao.deleteCustomer(8);
		
		// 모든 Customer List를 가져옴
		List<Customer> list = cDao.getCustomerList();
		for (Customer c2 : list) {
			System.out.println(c2);
		}
		System.out.println();
		
		// address 값에서 "대한민국"이란 단어를 검색해서 CustomerListByAddress 객체를 구해서 출력
//		List<Customer> list2 = cDao.getCustomerListByAddress("대한민국");
		// 또는
//		List<Customer> list3 = cDao.getCustomerListByFieldAndQuery("address","대한민국");
//		for (Customer c3 : list2) {
//			System.out.println(c3);
//		}
		
		// name 값에서 field값의 "박"이란 query값을 검색해서 CustomerListByName 객체를 구해서 출력
		List<Customer> list3 = cDao.getCustomerListByFieldAndQuery("name","박");
		for (Customer c4 : list3) {
			System.out.println(c4);
		}
	}

}
