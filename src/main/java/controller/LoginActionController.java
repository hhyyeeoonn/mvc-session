package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/LoginActionController")
public class LoginActionController extends HttpServlet {
   private MemberService memberService;
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 로그인 전에만 진입가능
      HttpSession session = request.getSession();
      // 로그인 전 : loginMember -> null
      // 로그인 후 : loginMember -> not null
      Member loginMember = (Member)session.getAttribute("loginMember");
      if(loginMember != null) { // 이미 로그인 상태
         response.sendRedirect(request.getContextPath()+"/HomeController");
         return;
      }
      
      String memberId = request.getParameter("memberId");
      String memberPw = request.getParameter("memberPw");
      
      Member paramMember = new Member(); // request 파라미터값으로 바인딩
      paramMember.setMemberId(memberId);
      paramMember.setMemberPw(memberPw);
      
      this.memberService = new MemberService();
      
      Member returnMember = memberService.login(paramMember);
      
      if(returnMember == null) { // 로그인 실패
         response.sendRedirect(request.getContextPath()+"/LoginFormController");
         return;
      }
      
      session.setAttribute("loginMember", returnMember);
      response.sendRedirect(request.getContextPath()+"/HomeController");
   }
}
