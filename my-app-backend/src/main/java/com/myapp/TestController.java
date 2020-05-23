package com.myapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	private MemberBiz memberbiz;
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> Login (String id, String pw){
		System.out.println(id + ":" + pw);
		MemberDto dto = new MemberDto(id,pw);
		int res = memberbiz.selectMember(dto);
		
		Boolean result = false;
		if(res > 0) {
			System.out.println("로그인 성공");
			result = true;
		}else {
			System.out.println("로그인 실패");
			result = false;
		}
		
		return ResponseEntity.ok(result);
		//return ResponseEntity.ok("안녕");
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Boolean> Signup (String id, String pw){
		System.out.println(id + ":" + pw);
		MemberDto dto = new MemberDto(id,pw);
		int res = memberbiz.insertMember(dto);
		
		Boolean result = false;
		if(res > 0) {
			System.out.println("회원가입 성공");
			result = true;
		}else {
			System.out.println("회원가입 실패");
			result = false;
		}

		return ResponseEntity.ok(result);
		//return ResponseEntity.ok("안녕");
	}

	@PostMapping("/ip")
	public ResponseEntity<String> ip (HttpServletRequest request){
		// 요청을 보낸 클라이언트의 IP주소를 반환한다.
		return ResponseEntity.ok(request.getRemoteAddr());
		//return ResponseEntity.ok("안녕");
	}
	
	@PostMapping("/dateaxios")
	public ResponseEntity<String> under (HttpServletRequest request){
		// Date객체 생성
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String todayRes = format.format(today);
		return ResponseEntity.ok(todayRes);
	}
}
