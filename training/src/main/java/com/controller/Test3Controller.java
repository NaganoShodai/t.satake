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
public class Test3Controller {
	
	// 画面名
	private static final String PAGE_NAME = "test3";
	
	// アクセスURL定義(アクセスURL:http://localhost:8080/test3)
	@RequestMapping("/test3")
	public String disp(Model model4) {
		
		// モデル設定
		model4.addAttribute("text", "小鳥遊");
		// 画面遷移
		return PAGE_NAME;
	}
	
	// POST:リクエストURLにパラメータが付与されない
	@PostMapping("/input_4")
	public String input4(HttpServletRequest req, Model model) {
		
		// 入力値
		String input4= req.getParameter("input_4");
		// モデル設定
		req.setAttribute("disp_4", input4);
		// 画面遷移
		return PAGE_NAME;
	}

	// GET:リクエストURLにパラメータが付与される
	@GetMapping("/input_5")
	public String input2(HttpServletRequest req, Model model,
						// 入力値
						@RequestParam("input_5") String input5) {
		// モデル設定
		req.setAttribute("disp_5", input5);
		// 画面遷移
		return PAGE_NAME;
	}
}
