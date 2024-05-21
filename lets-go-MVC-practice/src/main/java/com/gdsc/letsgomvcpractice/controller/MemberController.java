package com.gdsc.letsgomvcpractice.controller;


import com.gdsc.letsgomvcpractice.domain.Member;
import com.gdsc.letsgomvcpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//스프링 컨테이너에 들어가 스프링이 직접 객체를 생성하여 관리한다.
public class MemberController {
    private final MemberService memberService;
    //@Autowired private MemberService memberService;(field 주입, 별로 안좋음)
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        //계속 public으로 노출되어 있어 잘못 사용하면 안됨
//        this.memberService = memberService;
//    }

    @Autowired
    //spring 컨테이너에서 가져옴
    //spring 컨테이너에 해당 클래스가 빈으로 등록되어 있지 않다면 작동 불가능
    public MemberController(MemberService memberService) {
        //생성자 DI
        //한 번만 초기화 가능
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    //@GetMapping : 보통 url 창에다가 치는 것
    public String createForm(){
        return "members/createMemberForm";
        //createMemberForm이라는 파일로 이동
    }

    @PostMapping("/members/new")
    //@PostMapping : Form같은 것으로 들어와서 전달할 때 주로 사용
    //데이터가 이동할 때에 사용
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = "+member.getName());

        memberService.join(member);
        return "redirect:/";
        //전 화면(홈화면)으로 돌려 보냄
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        //html문서에 전달함, 거기서 "member"라는 이름을 가졌고 여기서 members라는 이름을 가진
        return "members/memberList";
    }
}
