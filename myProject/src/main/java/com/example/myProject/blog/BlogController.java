package com.example.myProject.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blog")
public class BlogController {
//	private BlogDao bDao = new BlogDao();
//	@Autowired private BlogDao bDao;	// Spring에서 BlogDao bDao 객체를 생성해서 injection해준다 <-- mybatis 사용시 주석처리
	@Autowired private BlogService blogService;		// Spring에서 BlogDaoMyBatis bDao라는 구현객체를 생성해서 injection해준다

/*
	
	public class BlogController {
	@Autowired private BlogService bDao;
	
	@GetMapping & PostMapping
	}
	BlogService bDao란 구현객체를 BlogServiceOracleImplement blogDao에 injection 해준다.
	
	@Service
	public class BlogServiceOracleImplement implements BlogService {
	
	@Autowired private BlogDaoOracleImplement blogDao;
	
	@Override
}
 */

	@GetMapping("/list")
	// 아래는 아주 기본적으로 구동되는 표현
	// - session을 적용하지 않기 때문에 top.jspf에서 이름 값을 가져오지 않는다
	public String list(@RequestParam(name="f", defaultValue="title") String field, 
						@RequestParam(name="q", defaultValue="") String query, Model model ) {
		List<Blog> list = blogService.getBlogList(field, query);
		model.addAttribute("blogList", list);
		model.addAttribute("menu", "blog");
		model.addAttribute("field", field);
		model.addAttribute("query", query);
		
		return "blog/list";
	}
	
	@GetMapping("/write")
	public String writeForm(Model model) {
		model.addAttribute("menu", "blog");
		return "blog/write";
	}
	
	@PostMapping("/write")
	// 방법 1:
	/*
	public String writeProc(String penName, String title, String content) {
		Blog blog = new Blog(penName, title, content);
		bDao.insertBlog(blog);
		return "redirect:/blog/list";	// "redirect:/location"을 이용하여 list가 있는 곳으로 보낸다
	}
	*/
	// 방법 2:
	public String writeProc(Blog blog) {
		blogService.insertBlog(blog);
		return "redirect:/blog/list";	// "redirect:/location"을 이용하여 list가 있는 곳으로 보낸다
	}
	
	@GetMapping("/detail/{blogId}")		// blogId를 불러온다
	public String detail(@PathVariable int blogId, String option, Model model) {
		if(option == null || option.equals(""))
			blogService.increaseViewCount(blogId);		// DNI option이 설정되어 있으면 조회수를 증가시키지 않는다
		Blog blog = blogService.getBlog(blogId);	// blogId를 넣어준다.
		model.addAttribute("blog", blog);
		model.addAttribute("menu", "blog");
		
		return "blog/detail";
	}
	
	@GetMapping("/update/{blogId}")		// blogId를 불러온다
	public String updateForm(@PathVariable int blogId, Model model) {
		Blog blog = blogService.getBlog(blogId);	// blogId를 넣어준다.
		model.addAttribute("blog", blog);
		model.addAttribute("menu", "blog");
	
		return "blog/update";
	}
	
	@PostMapping("/update")
	public String updateProc (Blog blog) {
//	public String updateProc(String penName, String title, String content) {  // 이렇게 써도 같다.
//	Blog blog = new Blog(bid, penName, title, content);
		blogService.updateBlog(blog);
		
		return "redirect:/blog/detail/" + blog.getBlogId() + "?option=DNI";
	}
	
	@GetMapping("/delete/{blogId}")
	public String deleteForm(@PathVariable int blogId, Model model) {
		// Blog blog = bDao.getBlog(blogId);	<--- 객체의 필드가 나오므로 updateForm 처럼 쓰지 않는다.
		model.addAttribute("blogId", blogId);
		model.addAttribute("menu", "blog");
	
		return "blog/delete";
	}
	
	@GetMapping("/deleteConfirm/{blogId}")
	public String deleteProc(@PathVariable int blogId) {
		blogService.deleteBlog(blogId);
		
		return "redirect:/blog/list";
	}
	
}