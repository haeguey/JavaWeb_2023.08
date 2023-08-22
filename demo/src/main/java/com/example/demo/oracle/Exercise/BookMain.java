package com.example.demo.oracle.Exercise;

import java.util.List;

import com.example.demo.oracle.Customer;
import com.example.demo.oracle.CustomerDao;

public class BookMain {

	public static void main(String[] args) {

		Book bk = new Book();
		
		// custId 값으로 검색해서 Customer 객체를 구해서 출력
		// Customer c1 = cDao.getCustomer(6);
		// System.out.println(c);
		
		
		// 모든 Customer List를 가져옴
		List<Book> list = cDao.getBookList();
		for (Book book : list) {
			System.out.println(book);
		}
				
		
		// cDao.insertCustomer(Customer c)
		
		
		
		// cDao.updateCustomer(Customer c)
		
		
		
		// cDao.deleteCustomer(int custId)
		
	}

}

	}

}
