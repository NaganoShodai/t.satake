package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import com.sun.istack.Nullable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class ThymeleafController {
	
	
	// 画面名
		private static final String PAGE_NAME = "home";
		

  @RequestMapping("/home")
  public String disp(Model model6) { 
	    
	    // RequestMappingの引数にModelを指定することで、
	    // テンプレートで使用するモデルに値を格納できる
	    model6.addAttribute("name","不明なユーザー");
	    model6.addAttribute("text","あなたは誰ですか");
	    model6.addAttribute("num1",5);
	    model6.addAttribute("num2",567);
	    model6.addAttribute("result",true);
	    
	    int num3=5;
	    boolean flg=num3<123;
	    

	    // テンプレートHTMLのファイル名を記載（拡張子は不要）
    return "home";
  }
}