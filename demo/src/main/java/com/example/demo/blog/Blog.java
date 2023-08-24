package com.example.demo.blog;

import java.time.LocalDateTime;

public class Blog {
	private int blogId;
	private String penName;
	private String title;
	private String content;
	private LocalDateTime modTime;
	private int viewCount;
	private int isDeleted;
	
	
	public Blog() {}

	// Insert 하는 경우 사용되는 생성자
	public Blog(String penName, String title, String content) {
		this.penName = penName;
		this.title = title;
		this.content = content;
	}

	// Update 하는 경우 사용되는 생성자
	public Blog(int blogId, String penName, String title, String content) {
		this.blogId = blogId;
		this.penName = penName;
		this.title = title;
		this.content = content;
	}

	public Blog(int blogId, String penName, String title, String content, LocalDateTime modTime, int viewCount,
			int isDeleted) {
		this.blogId = blogId;
		this.penName = penName;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.viewCount = viewCount;
		this.isDeleted = isDeleted;
	}
	
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", penName=" + penName + ", title=" + title + ", content=" + content
				+ ", modTime=" + modTime.toString().substring(2, 16).replace("T", " ") + ", viewCount=" + viewCount + ", isDeleted=" + isDeleted + "]";
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getModTime() {
		return modTime;
	}

	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
