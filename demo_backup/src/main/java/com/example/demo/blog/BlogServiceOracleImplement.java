package com.example.demo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceOracleImplement implements BlogService {
	
	@Autowired private BlogDaoOracleImplement blogDao;

	@Override
	public Blog getBlog(int blogId) {
		Blog blog = blogDao.getBlog(blogId);
		return blog;
	}

	// ${query}를 직접 쓸 수 없으므로 이렇게 적는다 ***************
	@Override
	public List<Blog> getBlogList(String field, String query) {
		query = "%" + query + "%";
		List<Blog> list = blogDao.getBlogList(field, query);
		return list;
	}
	// ************************************************************

	@Override
	public void insertBlog(Blog blog) {
		blogDao.insertBlog(blog);
				
	}

	@Override
	public void updateBlog(Blog blog) {
		blogDao.updateBlog(blog);
				
	}

	@Override
	public void deleteBlog(int blogId) {
		blogDao.deleteBlog(blogId);
			
	}

	@Override
	public void increaseViewCount(int blogId) {
		blogDao.increaseViewCount(blogId);
		
	}

}
