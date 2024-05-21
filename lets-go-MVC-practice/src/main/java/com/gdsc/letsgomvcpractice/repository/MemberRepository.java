package com.gdsc.letsgomvcpractice.repository;



import com.gdsc.letsgomvcpractice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //인페이스는 인터페이스와 구현체로 나누어져 있다.
    //구현체 : 인터페이스를 재정의 하여 구현된 클래스
    Member save(Member member);//저장하기
    Optional<Member> findById(Long id);//Id(키)로 찾기
    Optional<Member> findByName(String name);//이름으로 찾기
    List<Member> findAll();//모두 찾아서 반환하기
}
