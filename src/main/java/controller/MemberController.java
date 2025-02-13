package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		
		try {
			if(cmd.equals("/login.member")) {
				// TODO: 로그인
				// 인자값: id, password 
			} else if(cmd.equals("/mypage.member")) {
				// TODO: 마이 페이지로 보내기
			} else if(cmd.equals("/delete.member")) {
				//  TODO: 회원 탈퇴
				//  인자값: id
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		
		try {
			if(cmd.equals("/signup.member")) {
				// TODO: 회원 가입
				// 인자값: id, password, name, email, phone, postcode, address1, address2
			} else if(cmd.equals("/update.member")) {
				// TODO: 회원 정보 수정
				// 인자값: id, name, email, phone, postcode, address1, address2
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
