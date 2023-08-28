package com.example.demo.blog;

import java.util.List;

public class BlogTest {

	public static void main(String[] args) {
		BlogDao bDao = new BlogDao();
		
		// insert
//		Blog blog = new Blog("프로그래머", "자바", "자바는 객체지향 프로그램...");
//		bDao.insertBlog(blog);
		
//		Blog b = bDao.getBlog(3);
//		System.out.println(b);		// modTime의 출력 부분은 Blog.java의 toString 부분을 참고한다.

		
/*		BlogDao bDao1 = new BlogDao();
		Blog b1 =bDao.getBlog(4);
		b1.setTitle("Python");
		b1.setContent("Python is easy programming language.");
		bDao1.updateBlog(b1);
*/
		// delete
//		bDao.deleteBlog(2);
		
		bDao.increaseViewCount(1);
		bDao.increaseViewCount(3);
		bDao.increaseViewCount(1);
		bDao.increaseViewCount(4);
		
		
		List<Blog> list = bDao.getBlogList("title", "");
		for (Blog b2 : list) {
			System.out.println(b2);		// modTime의 출력 부분은 Blog.java의 toString 부분을 참고한다.
		}
	
	}

}
