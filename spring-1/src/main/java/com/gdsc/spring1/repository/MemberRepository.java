package com.gdsc.spring1.repository;

import com.gdsc.spring1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//Member를 저장시킴
    Optional<Member> findById(Long id);//id를 찾음
    //Optional : null 값 처리에 도움을 줌
    Optional<Member> findByName(String name);
    List<Member> findAll();//전부 찾기 반환 타입 List
}
