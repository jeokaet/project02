package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private DataSource ds;
	private MemberDAO dao;

	private String encrypt(String text) { // 비밀번호 암호화 메서드
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] digest = md.digest();

			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getRequestURI();

		try {
			if (cmd.equals("/login.member")) {
				String id = request.getParameter("id");
				String password = encrypt(request.getParameter("password"));

				MemberDTO login = dao.login(id, password);
				if (login) {
					request.getSeesion().setAttribute("LoginID", id);
					response.sendRedirect("/index.jsp");
				}else {
					response.sendRedirect("/error.jsp")
				}
			} else if (cmd.equals("/mypage.member")) {
				// TODO: 마이 페이지로 보내기
				HttpSession session = request.getSession();
				String dto = (String) session.getAttribute("dto");
				
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/list.jsp").forward(request, response);	//어디로보냄?
				
			} else if (cmd.equals("/delete.member")) {
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("loginID");
				try {
					int result = dao.delete(id);
					if(result > 0) {
						session.invalidate();
						response.sendRedirect("/index.jsp");
					}
				}catch(Exception e) {
					e.printStackTrace();
					response.sendRedirect("/error.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		request.setCharacterEncoding("utf8");
		try {
			if(cmd.equals("/signup.member")) {
			String id=request.getParameter("id");
			String password = encrypt(request.getParameter("password"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int postcode = Integer.parseInt(postcodeStr);
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			
			try {
				int result = dao.singup(id,password,name,phone,postcode,address1,address2);
				
				if(result > 0) {
					System.out.println("성공");
					response.sendRedirect("/");	//어디로갈거냐
				}
			}
			} else if(cmd.equals("/update.member")) {
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("dto");
				if(id == null) {
					response.sendRedirect("/signup.jsp");	//파일이 singup으로 바꾸는게 좋아보여요
					return;
				}
				String id=request.getParameter("id");
				String password = encrypt(request.getParameter("password"));
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				int postcode = Integer.parseInt(postcodeStr);
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				try {
					int reuslt = dao.update(id, password, name,email,phone,postcode,address1,address2);
					
					if(result > 0) {
						response.sendRedirect("/mypage.member");
					}else {
						response.sendRedirect("/error.jsp");
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
