package com.gdsc.spring1.controller;

import com.gdsc.spring1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired//spring 컨테이너와 연결되어 가져옴
    //연결 시켜줄 때 사용함
    public MemberController(MemberService memberService) {

        this.memberService = memberService;

    }
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
}
