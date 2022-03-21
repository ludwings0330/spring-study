package com.example.springstudy.login.controller;

import com.example.springstudy.login.LoginReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/login/info")
    @ResponseBody
    public String getCookieInfo(@CookieValue(name = "memberId", required = false) String loginId) {
        if (loginId == null) {
            return "no cookie";
        }
        log.info("loginId : [{}]", loginId);
        return loginId;
    }

    @GetMapping("/login/cookie/v1")
    public String cookieLogin(@ModelAttribute LoginReqDto loginReqDto, BindingResult bindingResult,
                              HttpServletResponse response) {
        if (loginReqDto.getId().equals("ludwings") && loginReqDto.getPassword().equals("1234")) {
            Cookie cookie = new Cookie("memberId", loginReqDto.getId());
            response.addCookie(cookie);

            return "redirect:/login/info";
        }

        return "login/loginForm";
    }

    @GetMapping("/logout/cookie/v1")
    public String cookieLogout(HttpServletResponse response) {
        final Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/login/session/v1")
    public String sessionLogin(@ModelAttribute LoginReqDto loginReqDto, BindingResult bindingResult,
                               HttpServletRequest request, HttpServletResponse response) {
        if (loginReqDto.getId().equals("ludwings") && loginReqDto.getPassword().equals("1234")) {
            final HttpSession session = request.getSession();
            session.setAttribute("loginMember", loginReqDto);

            return "redirect:/login/info";
        }

        return "login/loginForm";
    }

    @GetMapping("/logout/session/v1")
    public String sessionLogout(HttpServletRequest request, HttpServletResponse response) {
        final HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping("/login/session/info")
    @ResponseBody
    public String getSessionInfo(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final LoginReqDto loginMember = (LoginReqDto) session.getAttribute("loginMember");
        return "/";
    }

    @GetMapping("/")
    public String homeLoginSpring(@SessionAttribute(name = "loginMember", required = false) LoginReqDto reqDto,
                                  Model model) {
        model.addAttribute("member", reqDto);
        return "loginHome";
    }
}
