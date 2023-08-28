package com.example.demo;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

// import jakarta.servlet.http.HttpServletRequest;	// <version>3.1.2</version>에서 사용
import javax.servlet.http.HttpServletRequest;

//@Controller
//@RequestMapping("/bs")
public class BootstrapController {
	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;
    
    @GetMapping("/login")
    public String login(){
        return "bs/login";
    }

    @PostMapping("/login1")
    @ResponseBody
    public String login1(HttpServletRequest req){
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String remember = req.getParameter("remember");

        return "<h2>email: " + email + ", pwd: " + pwd + ", remember: " + remember + "</h2>";
    }

    @PostMapping("/login2")
    @ResponseBody
    public String login2(String email, String pwd, String remember){

        return "<h2>email: " + email + ", pwd: " + pwd + ", remember: " + remember + "</h2>";
    }
    
    @GetMapping("/register")
    public String registerForm(){
        return "bs/register";
    }
    
    @PostMapping("/register")
    @ResponseBody
    public String registerProc(MultipartHttpServletRequest req){
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        String rePwd = req.getParameter("rePwd");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String html = String.format("<h2>%s, %s, %s, %s, %s, %s</h2>", uid, pwd, rePwd, name, email, gender);
        
        // 파일 읽기
        MultipartFile filePart = req.getFile("profile");
        if(filePart.getContentType().contains("image")) {	// 사진을 보냈음
        	String filename = filePart.getOriginalFilename();
        	html += "<h2>" + filename + "</h2>";
        	String profilePath = uploadDir + filename;
        	try {
				filePart.transferTo(new File(profilePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
         return html;
    }
    
    @PostMapping("/register2")
    public String register2Proc(MultipartHttpServletRequest req){
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        String rePwd = req.getParameter("rePwd");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String html = String.format("<h2>%s, %s, %s, %s, %s, %s</h2>", uid, pwd, rePwd, name, email, gender);
        
        // 파일 읽기
        MultipartFile filePart = req.getFile("profile");
        if(filePart.getContentType().contains("image")) {	// 사진을 보냈음
        	String filename = filePart.getOriginalFilename();
        	html += "<h2>" + filename + "</h2>";
        	String profilePath = uploadDir + filename;
        	try {
				filePart.transferTo(new File(profilePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        if( !checkUid(uid)) {
        	System.out.println("uid: " + uid + "이/가 이미 존재함");
        	return "redirect:/bs/register";
        	// alert message 내보내고,
        	// 회원가입 화면으로 되돌려 보내야 함
        } else {
        	if (pwd != null && pwd.equals(rePwd)) {
        		System.out.println(name + "님 환영합니다.");
        		return "redirect:/bs/login/";
        		// 올바른 회원가입
        		// 로그인 화면으로 보내줌
        	} else {
        		System.out.println("패스워드를 올바르게 입력하세요.");
            	return "redirect:/bs/register";
        		// 패스워드 에러에 대한 경고 메세지
        		// 회원가입 화면으로 되돌려 보내야 함
        	}
        }
    }
    
    @PostMapping("/register3")
    public String register3Proc(MultipartHttpServletRequest req, Model model){
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        String rePwd = req.getParameter("rePwd");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String html = String.format("<h2>%s, %s, %s, %s, %s, %s</h2>", uid, pwd, rePwd, name, email, gender);
        
        // 파일 읽기
        MultipartFile filePart = req.getFile("profile");
        if(filePart.getContentType().contains("image")) {	// 사진을 보냈음
        	String filename = filePart.getOriginalFilename();
        	html += "<h2>" + filename + "</h2>";
        	String profilePath = uploadDir + filename;
        	try {
				filePart.transferTo(new File(profilePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        if( !checkUid(uid)) {
        	model.addAttribute("msg", "uid: " + uid + "이/가 이미 존재함");
        	model.addAttribute("url", "/demo/bs/register");
        	return "bs/alertMsg";
         	// alert message 내보내고,
        	// 회원가입 화면으로 되돌려 보내야 함
        } else {
        	if (pwd != null && pwd.equals(rePwd)) {
            	model.addAttribute("msg", name + "님 환영합니다.");
            	model.addAttribute("url", "/demo/bs/login");
        		return "bs/alertMsg";
        		// 올바른 회원가입
        		// 로그인 화면으로 보내줌
        	} else {
            	model.addAttribute("msg", "패스워드를 올바르게 입력하세요.");
            	model.addAttribute("url", "/demo/bs/register");
            	return "bs/alertMsg";
        		// 패스워드 에러에 대한 경고 메세지
        		// 회원가입 화면으로 되돌려 보내야 함
        	}
        }
    }
    
    // uid가 DB에 존재하면 false, 없으면 true
    boolean checkUid(String uid) {
    	if( Math.random() < 0.9)
    		return true;
    	return false;
    }
}