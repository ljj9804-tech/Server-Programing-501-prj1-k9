package com.busanit501.jsp_server_project1._0209_todo.controller;

import com.busanit501.jsp_server_project1._0209_todo.dto._0209_18_MemberDTO;
import com.busanit501.jsp_server_project1._0209_todo.service._0209_21_MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name="_0209_13_LoginController", urlPatterns = "/login_0209")
public class _0209_13_LoginController extends HttpServlet {
    // 앞에 만들었던, 멤버서비스의 기능을 의존하고, 부탁하고, 용역주기.
    _0209_21_MemberService memberService = _0209_21_MemberService.INSTANCE;

    // 로그인 화면 필요.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("로그인 화면을 제공하는 컨트롤러입니다.");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }
    // 로그인 처리 필요.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("로그인 처리를 담당하느 doPost 입니다. ");

        // 화면에서, 전달받은 mid, mpw 정보를 가져오기. 무조건 문자열이다.
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        // 데이터베이스 로직처리로 변경, 이전 코드는 0206를 참고하기.
        try {
            // 화면에 입력한 mid,mpw 내용이 데이터베이스 있다면, 정상 로그인 처리.
            // 없다면 예외를 발생시켜셔 로그인 페이지로 보내고, 보내는데,
            // 쿼리 스트링으로 result=error 같이 전달.
            _0209_18_MemberDTO memberDTO = memberService.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list_0209");

        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    } //doPost
}
