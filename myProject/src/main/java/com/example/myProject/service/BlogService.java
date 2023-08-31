package com.example.myProject.service;

import java.util.List;

import com.example.myProject.model.Blog;

public interface BlogService {

	Blog getBlog(int blogId);
	
	List<Blog> getBlogList(String field, String query);
	
	void insertBlog(Blog blog);
	
	void updateBlog(Blog blog);
	
	void deleteBlog(int blogId);
	
	void increaseViewCount(int blogId);
}
