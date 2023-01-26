package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.City;
import com.entity.User;

import com.repository.UserRepository;

/**
 *　login.html用のコントローラー
 */
@Controller
public class LoginController {
	
	// Userテーブル用リポジトリ
	@Autowired private UserRepository userRep;
	// 画面名
	private static final String PAGE_NAME = "login";
	
	// アクセスURL定義(アクセスURL:http://localhost:8080/login)
	@RequestMapping("/login")
	public String disp(Model model) {
		
		// インスタンス生成
		//LoginClass loginClass = new LoginClass();
		// モデル設定
		//model.addAttribute("LoginClass", loginClass);
		// 画面遷移
		return PAGE_NAME;
	}
	

	// POST:リクエストURLにパラメータが付与されない
	@PostMapping("/loginsubmit")
	public String adpw1(HttpServletRequest req, Model model
						) {
		
		// 入力値
		//String adpw1=loginClass.getInput_1();
		//model.addAttribute("LoginClass", loginClass);
		
		
		String md1 = req.getParameter("md");
		String pw1 = req.getParameter("pw");
		
		/*
		model.addAttribute("pwreturn",pw1);
		model.addAttribute("mdreturn",md1);
		*/
		
		// エラーメッセージ
		List<String> errMsgs = inputCheck(md1, pw1);
		// エラーが存在する場合
		if(0 < errMsgs.size()) {
			// モデル設定
            model.addAttribute("error_massage", errMsgs);
            // 遷移
			return PAGE_NAME;
			
		// 正常である場合
		}else {
			
			//updateが必要な箇所です。
			// テーブルから検索処理
			User user = userRep.findByEmailAndPassword(md1,pw1);
			
			//テーブル検索結果の分岐
			if(user != null){
				
				// 遷移
				return "redirect:top";
	           
	        //　該当ユーザーが存在しない場合
	        }else{
	        	
				// エラーメッセージ設定
	        	errMsgs.add("メールアドレスまたはパスワードが間違えています。");
	            model.addAttribute("error_massage", errMsgs);
	            
				// 画面遷移
				return PAGE_NAME;
	        }
			
			//model.addAttribute("certification1",existsByEmail);
			//model.addAttribute("certification2",existsByPassword);
			
			//model.addAttribute("pwreturn",pw1);
			//model.addAttribute("mdreturn",md1);
			
			//テーブルの値の受取処理
			//List<User> users = userRep.findAll();
			//model.addAttribute("userlist",users);
			
			// モデル設定
			//req.setAttribute("disp_1", adpw1);
		}
	}
	
	/**
	 * 入力チェック
	 * @param email メールアドレス
	 * @param password パスワード
	 * @return エラーメッセージリスト
	 */
	private static List<String> inputCheck(String email, String password) {
		
		// エラーメッセージリスト
		List<String> errMsgs = new ArrayList<String>();
		
		// メーリアドレスが未入力の場合
		if(email.equals("")) {
			errMsgs.add("メールアドレス入力してください");
		}
		// パスワードが未入力の場合
		if(password.equals("")) {
			errMsgs.add("パスワードを入力してください");
		}
		
		// 返却
		return errMsgs;
	}
}
	