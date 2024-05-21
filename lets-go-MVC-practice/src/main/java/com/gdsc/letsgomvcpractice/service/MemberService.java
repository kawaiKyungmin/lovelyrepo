package com.gdsc.letsgomvcpractice.service;

import com.gdsc.letsgomvcpractice.domain.Member;
import com.gdsc.letsgomvcpractice.repository.MemberRepository;
import com.gdsc.letsgomvcpractice.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//컴포넌트 스캔 방식
public class MemberService {
    private final MemberRepository memberRepository;


    //spring bean에서 MemberRepository가 필요한 것을 확인하고 등록된 MemberRepository를 가져온다.
    public MemberService(MemberRepository memberRepository) {//DI
        this.memberRepository = memberRepository;
    }



    //중복된 회원을 검사하는 메소드

    /**
     * 회원 가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원 X
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //클래스 Member를 따르는 result 제작
        //result는 <Member>의 형태를 가짐,
        //result는 파라미터 member가 가지고 있는 name 필드를 가지고 있음
        validateDuplicateMember(member);

        memberRepository.save(member);
        //save를 호출하여 받은 파라미터를 넣어서 세이브함
        return member.getId();//저장한 멤버를 리턴
    }

    /**
     * 전체 회원 조회
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    //ifPresent()에 해당되는 값을 가지고 있으면  true 값이 없다면 false 리턴
                    //result에 값이 있으면 해당 람다식 실행
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
