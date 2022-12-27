package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 후에만 진입가능
		HttpSession session = request.getSession();
		// 로그인 전 : loginMember -> null
		// 로그인 후 : LoginMember -> not null
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) { // 로그인 전
			response.sendRedirect(request.getContextPath() + "/LoginFormController");
			return;
		}
		
		String loginMemberId = loginMember.getMemberId();
		request.setAttribute("loginMember", loginMemberId);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
	    rd.forward(request, response);
	}
}
