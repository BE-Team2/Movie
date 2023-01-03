package com.example.movie.login.service;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.entity.Member;
import com.example.movie.login.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class LoginService {

    private final LoginRepository loginRepository;
    private final HttpSession session;

    public LoginService(LoginRepository loginRepository, HttpSession session) {
        this.loginRepository = loginRepository;
        this.session = session;
    }

    public String loginUserIdPassword(MemberDTO memberDTO) {
       MemberDTO member = loginRepository.loginUserIdPassword(memberDTO);
        if (member != null) {
            log.info("memberInfo = {}",member.toString());
            session.setAttribute("nickname",member.getNickname());
            return memberDTO.getNickname();
        }
        return "error";
    }
}