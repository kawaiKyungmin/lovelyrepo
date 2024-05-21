package com.gdsc.spring1.service;

import com.gdsc.spring1.domain.Member;
import com.gdsc.spring1.repository.MemberRepository;
import com.gdsc.spring1.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {



    private final MemberRepository memberRepository = new MemoryMemberRepository();


    public Long join(Member member){
            //같은 이름이 있는 중복 회원 X
            //ctrl + alt + v
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {//.ifPresent 속해이있다
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
            return member.getId();
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
