package com.example.demo.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.oracle.Customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogDao {

	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
/*	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "hmuser";
	private String password = "hmpass";
*/	
	public Blog getBlog(int blogId) {
		String sql = "select * from blog where blogId=?";
		Blog blog = null;
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, blogId);
			
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				blogId = rs.getInt(1);
				String penName = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String modTime = rs.getString(5);
				int viewCount = rs.getInt(6);
				int isDeleted = rs.getInt(7);
				blog = new Blog(blogId, penName, title, content, LocalDateTime.parse(modTime.substring(0, 19).replace(" ", "T")), viewCount, isDeleted);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blog;
	}
	
	public void insertBlog(Blog blog) {
		String sql = "insert into blog(penName, title, content) values(?,?,?)";
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, blog.getPenName());
			pstmt.setString(2, blog.getTitle());
			pstmt.setString(3, blog.getContent());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Blog> getBlogList(String field, String query){
		String sql = "select * from blog where " + field + " like ? and isDeleted=0 "
				+ " order by modTime desc";
		List<Blog> list = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				int blogId = rs.getInt(1);
				String penName = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String modTime = rs.getString(5);
				int viewCount = rs.getInt(6);
				int isDeleted = rs.getInt(7);
				Blog blog = new Blog(blogId, penName, title, content,
							LocalDateTime.parse(modTime.substring(0, 19).replace(" ", "T")), 
							viewCount, isDeleted);
				list.add(blog);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateBlog(Blog blog) {	// method의 signature

		String sql = "update blog set penName=?, title=?, content=?, modTime=current_timestamp "
					+ " where blogid=?";
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, blog.getPenName());
			pstmt.setString(2, blog.getTitle());
			pstmt.setString(3, blog.getContent());
			pstmt.setInt(4, blog.getBlogId());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// delete Blog를 쓰지 않고 update에 있는 setDelete을 이용한다.
	public void deleteBlog(int blogId) {
		String sql = "update blog set isDeleted=1 where blogId=?";
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, blogId);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void increaseViewCount(int blogId) {
		String sql = "update blog set viewCount=viewCount+1 where blogId=?";
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, blogId);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
