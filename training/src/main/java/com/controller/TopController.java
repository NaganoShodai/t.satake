package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *　test1.html用のコントローラー
 */
@Controller
public class TopController {
	
	// 画面名
	private static final String PAGE_NAME = "top";
	
	// アクセスURL定義(アクセスURL:http://localhost:8080/test1)
	@RequestMapping("/top")
	public String disp(Model model) {
		
		
		// 画面遷移
		return PAGE_NAME;
	}
}
	