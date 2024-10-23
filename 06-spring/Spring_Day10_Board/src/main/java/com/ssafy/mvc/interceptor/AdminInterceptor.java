package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);  // 세션이 없으면 null 반환

        if (session == null || session.getAttribute("loginUser") == null) {
            response.sendRedirect("/login");
            return false;
        }

        if (!"admin".equals(session.getAttribute("loginUser"))) {
            response.sendRedirect("/list");
            return false;
        }

        return true;  // 관리자인 경우 요청 허용
    }
}
