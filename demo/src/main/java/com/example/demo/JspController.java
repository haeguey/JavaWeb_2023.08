package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// import jakarta.servlet.http.HttpSession;	// <version>3.1.2</version>에서 사용
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/jsp")
public class JspController {

	@GetMapping("/sample")
	public String sample(Model model) {
		model.addAttribute("topMenu", "user");
		return "jsp/sample";
	}
	
	@GetMapping("/schedule")
	public String schedule(Model model) {
		model.addAttribute("topMenu", "schedule");
		return "jsp/schedule";
	}
	
	@GetMapping("/elOperator")
	public String elOperator() {
		return "jsp/el1_operator";
	}
	
	@GetMapping("/elScope")
	public String elScope(HttpSession session, Model model) {
		session.setAttribute("sName", "sName");
		model.addAttribute("mName", "mName");
		session.setAttribute("name", "sName");
		model.addAttribute("name", "mName");
		return "jsp/el2_scope";
	}
	
	@GetMapping("/elCollections")
	public String elCollections(Model model) {
		//String[] fruits = {"참외", "수박", "복숭아", "토마토"};
		String[] fruits = "참외, 수박, 복숭아, 토마토".split(",");
		
		// request
		model.addAttribute("fruitArray", fruits);	
		
		// list
		List<String> sports = new ArrayList<>();	
		sports.add("축구");
		sports.add("야구");
		sports.add("배구");
		model.addAttribute("sportList", sports);	// JSP로 넘겨주는 방법
		
		// MAP
		Map<String, String> map = new HashMap<>();
		// Map을 만들어 JSP로 보내기
		map.put("key", "el");
		map.put("value", "jstl");
		model.addAttribute("map", map);	// JSP로 보내기
		
		return "jsp/el3_collections";
	}
	
	@GetMapping("/elPojo")
	public String elPojo(Model model) {
		Address addr1 = new Address(12345, "LA", "미국");
		Address addr2 = new Address(67890, "NY", "미국");
		Member mem1 = new Member(101, "James", addr1);
		Member mem2 = new Member(102, "Maria", addr2);
		
		// ========== JSP로 보내기 ============
		model.addAttribute("mem1", mem1);
		model.addAttribute("mem2", mem2);
		
		Member[] members = {mem1, mem2};
		model.addAttribute("memberArray", members);
		
		List<Member> list = new ArrayList<>();
		list.add(mem1);
		list.add(mem2);
		model.addAttribute("memberList", list);
		// ======================================
		
		return "jsp/el4_pojo";
	}
	
	@GetMapping("/jstlCore")
	public String jstlCore(Model model) {
		Address addr1 = new Address(12345, "LA", "미국");
		Address addr2 = new Address(67890, "NY", "미국");
		Member mem1 = new Member(101, "James", addr1);
		Member mem2 = new Member(102, "Maria", addr2);
		Member mem3 = new Member(103, "홍길동", new Address(23456, "서울", "한국"));
		Member mem4 = new Member(104, "김Java", new Address(13579, "제주", "한국"));
		
		// ========== JSP로 보내기 ============
		
		// ************ Array로 보내기 *************
		model.addAttribute("mem1", mem1);
		model.addAttribute("mem2", mem2);
		model.addAttribute("mem3", mem3);
		
		Member[] members = {mem1, mem2, mem3, mem4};
		model.addAttribute("memberArray", members);
		// *****************************************
		
		// ---------- List로 보내기 --------------
		List<Member> list = new ArrayList<>();
		list.add(mem1);
		list.add(mem2);
		list.add(mem3);
		list.add(mem4);
		model.addAttribute("memberList", list);
		// ----------------------------------------
		
		// ======================================
		
		return "jsp/jstl1_core";
	}
	
	@GetMapping("/jstlFmt")
	public String jstlFmt(Model model) {
		int price = 12345000;
		Date now = new Date();
		model.addAttribute("price", price);
		model.addAttribute("now", now);
		
		LocalDate ldNow = LocalDate.now();
		LocalTime ltNow = LocalTime.now();
		LocalDateTime ldtNow = LocalDateTime.now();
		model.addAttribute("ldNow", ldNow);
		model.addAttribute("ltNow", ltNow);
		model.addAttribute("ltNow2", ltNow.toString().substring(0, 8));
		model.addAttribute("ldtNow", ldtNow);
		model.addAttribute("ldtNow2", ldtNow.toString().substring(0, 19).replace("T", " "));
		
		return "jsp/jstl2_fmt";
	}
	
	@GetMapping("/jstlFn")
	public String jstlFn(Model model) {
		model.addAttribute("str1", "hello world!");
		model.addAttribute("str2", "쇼핑몰의 중심 JSP Mall");
		model.addAttribute("str3", "중심");
		return "jsp/jstl3_fn";
	}
	
}
