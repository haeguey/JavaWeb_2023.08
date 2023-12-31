package com.example.demo;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// import jakarta.servlet.http.HttpServletRequest;	// <version>3.1.2</version>에서 사용
// import jakarta.servlet.http.HttpSession;			// <version>3.1.2</version>에서 사용

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class DemoController {
	// http://localhost:8080/demo/hello
	
	String a_= null, b_= null, op = null;
	int a = 0, b = 0, result = 0;
	
	@GetMapping("/index")
	@ResponseBody
	public String index() {
		return "<h1>Hello World!!!</h1>";
	}
	
	// http://localhost:8080/demo/hello
	@GetMapping("/hello")
	public String hello() {
		return "01.hello";
	}
	
	@GetMapping("/login")
	public String login() {
		return "02.login";
	}
	
	@PostMapping("/login")
//  @ResponseBody
	public String loginProc(HttpServletRequest req, Model model) {
		String uid = req.getParameter("uid");	// "uid"가 input tag의 name 값
		String pwd = req.getParameter("pwd");
//		return "<h1>uid=" + uid + ", pwd=" + pwd + "</h1>";
		
		model.addAttribute("uid", uid);
		model.addAttribute("pwd", pwd);
		return "03.loginResult";
	}
	
	@GetMapping("/getParam")
	@ResponseBody
	public String getParam(HttpServletRequest req) {
		// System.out.println("getParam()");
		String a_ = req.getParameter("a");
		String b_ = req.getParameter("b");
		String op = req.getParameter("op");
		int a = Integer.parseInt(a_);
		int b = Integer.parseInt(b_);
		int result = 0;
		String oper = "";
		switch(op) {
			case "add":
				result = a + b; oper = "+";
				break;
			case "sub":
				result = a - b; oper = "-";
				break;
			case "mul":
				result = a * b; oper = "*";
				break;
			case "div":
				result = (int) (a / b); oper = "/";
				break;
			default:
				result = 0;
		}
		return "<h1>" + a + oper + b + " = " + result + "</h1>";
	}
	
	@GetMapping("/calc")
	public String calcForm() {
		return "04.calcForm";
	}
	
	@PostMapping("/calc")
	public String calcProc(int a, int b, String op, Model model) {
		int result = 0;
		String oper = "";
		switch(op) {
			case "add":
				result = a + b; oper = "+";
				break;
			case "sub":
				result = a - b; oper = "-";
				break;
			case "mul":
				result = a * b; oper = "*";
				break;
			case "div":
				result = (int) (a / b); oper = "/";
				break;
			default:
				result = 0;
		}
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("oper", oper);
		model.addAttribute("result", result);
		
		return "05.calcResult";
	}
	
	@GetMapping("/write")
	public String writeForm() {
		return "06.writeForm";
	}
	
	@PostMapping("/write")
	public String writeProc(HttpServletRequest req, Model model) {

		String title = req.getParameter("title");
		String[] languages = req.getParameterValues("language");
		String content = req.getParameter("content");
		
		String joinLanguages = (languages == null)?"":String.join(", ",  languages);
		// If (languages == null) is true, enter "". If false, String.join(...) 
		Board board = new Board(title, joinLanguages, content.replace("\n", "<br>"));
		// System.out.println(board);
		model.addAttribute("board", board);
		
		return "07.writeResult";
	}
	
	@GetMapping("/calculator_sol")
	public String calculatorForm(String eval, Model model) {
		model.addAttribute("eval", eval);
		return "08.calculator_sol";
	}
	
	@PostMapping("/calculator_sol")
	public String calculatorProc(HttpServletRequest req, HttpSession session, Model model) {
		String num_ = req.getParameter("num");
		String op_ = req.getParameter("op");
		Object obj = session.getAttribute("stack");
		Stack<String> stack = (obj == null) ? new Stack<>() : (Stack) obj;
		
		if (num_ != null) {
			if (stack.isEmpty()) {
				stack.push(num_);
			} else {
				String element = stack.pop();
				if (element.equals("/") || element.equals("*")
						|| element.equals("-") || element.equals("+")) {
					stack.push(element);
					stack.push(num_);
				} else {
					num_ = element + num_;
					stack.push(num_);
				}
			}
			session.setAttribute("stack", stack);
			model.addAttribute("eval", getEval(stack));
		} else if (op_ != null && !op_.equals("=")) {
			if (op_.equals("C")) {
				if (stack.isEmpty())
					;
				else {
					String s = stack.pop();
					if (s.length() > 1) {
						s = s.substring(0, s.length()-1);
						stack.push(s);
					}
				}
			} else 
				stack.push(op_);
			session.setAttribute("stack", stack);
			model.addAttribute("eval", getEval(stack));
		} else {
			int result = 0;
			int num2 = Integer.parseInt(stack.pop());
			String op = stack.pop();
			int num1 = Integer.parseInt(stack.pop());
			switch(op) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = (int) (num1 / num2); break;
			default: result = 0;
			}
			session.removeAttribute("stack");
			model.addAttribute("eval", result);
		}
		return "08.calculator_sol";
	}
	
	String getEval(Stack<String> stack) {
		String eval = "";
		for (String s: stack)
			eval += s + " ";
		return eval;
	}
	
	@GetMapping("/calculator")
	public String calculator2Form() {
		return "08.calculator";
	}
	
	@PostMapping("/calculator")
	public String calculator() {
		return "08.calculator";
	}
}
