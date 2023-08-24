package com.example.demo.oracle.Exercise;

import java.util.List;

import com.example.demo.oracle.Customer;
import com.example.demo.oracle.CustomerDao;

public class BookTest {

	public static void main(String[] args) {

		BookDao bDao = new BookDao();
		Book b = bDao.getBook(5);
		// System.out.println(b);
		
		// bookId 값으로 검색해서 Book 객체를 구해서 출력
		// Book b = bDao.getBook(6);
		// System.out.println(b);
		
		// cDao.insertBook(Book b1)
//		Book b1 = new Book(14, "파이썬 웹 프로그래밍", "한빛미디어", 32000);
//		bDao.insertBook(b1);
//		System.out.println(b1);
		
		// 모든 Book List를 가져옴
		List<Book> list = bDao.getBookList();
		for (Book b2 : list) {
			System.out.println(b2);
		}
		//System.out.println(b2);
		
		// cDao.updateCustomer(Customer c)
		
		
		// cDao.deleteCustomer(int custId)
		
		// 모든 Customer List를 가져옴
		
		// address 값에서 "대한민국"이란 단어를 검색해서 CustomerListByAddress 객체를 구해서 출력
		
	}

}
