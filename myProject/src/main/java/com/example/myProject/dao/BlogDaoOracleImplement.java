package com.example.myProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.myProject.model.Blog;

@Mapper
public interface BlogDaoOracleImplement {

	// 	BlogDao.java에서 public Blog getBlog(int blogId) {} 와 같은 메소드를 mybatis를 이용해 작성
	@Select("select * from blog where blogId=#{blogId}")
	Blog getBlog(int blogId);
	
	
	// BlogDao.java에서 public List<Blog> getBlogList(String field, String query){} 와 같은 메소드를
	// mybatis를 이용해 작성
	// "select * from blog where " + field + " like ? and isDeleted=0 "
	// + " order by modTime desc";
	@Select("select * from blog where ${field} like #{query} and isDeleted=0 "
			+ " order by modTime desc")
	List<Blog> getBlogList(String field, String query);
	
	
	// "insert into blog(penName, title, content) values(?,?,?)"
	@Insert("insert into blog(penName, title, content) "
			+ " values(#{penName},#{title},#{content, jdbcType=VARCHAR})")
	void insertBlog(Blog blog);
	
	// 
	// update blog set penName=?, title=?, content=?, modTime=current_timestamp "
	// + " where blogid=?"
	@Update("update blog set penName=#{penName}, title={title}, content=#{content, jdbcType=VARCHAR}, modTime=current_timestamp "
			+" where blogid=#{blogId}")
	void updateBlog(Blog blog);
	
	// public Blog deleteBlog(int blogId)
	@Update("update blog set isDeleted=1 where blogId=#{blogId}")
	void deleteBlog(int blogId);
	
	
	//update blog set viewCount=viewCount+1 where blogId=?
	@Update("update blog set viewCount=viewCount+1 where blogId=#{blogId}")
	void increaseViewCount(int blogId);
}
