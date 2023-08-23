package com.example.demo.oracle.Exercise;

import java.util.List;

import com.example.demo.oracle.Customer;
import com.example.demo.oracle.CustomerDao;

public class BookTest {

	public static void main(String[] args) {

		BookDao bDao = new BookDao();
		Book b = bDao.getBook(5);
		// System.out.println(bk);
		
		// 모든 Customer List를 가져옴
		List<Book> list = bDao.getBookList();
		for (Book book : list) {
			System.out.println(book);
		}
				
		// custId 값으로 검색해서 Customer 객체를 구해서 출력
		// Customer c1 = cDao.getCustomer(6);
		// System.out.println(c);
		
		
		// cDao.insertCustomer(Customer c)
		
		
		// cDao.updateCustomer(Customer c)
		
		
		// cDao.deleteCustomer(int custId)
		
	}

}
