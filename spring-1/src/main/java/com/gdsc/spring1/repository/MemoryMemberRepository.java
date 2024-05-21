package com.gdsc.spring1.repository;

import com.gdsc.spring1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    //HashMap은 데이터를 저장할 때 키와 밸류가 짝을 이루어 저장된다. 데이터의 추가와 검색이 매우 빠르다는 장점이 있다.
    private static long sequence = 0L;//키 값을 생성

    //Long : Member Id를 저장
    //Member : 멤버 정보
    @Override//인터페이스 구현
    public Member save(Member member) {
        member.setId(++sequence);//key값을 하나 높이고 아이디를 보냄
        store.put(member.getId(),member);//member에서 아이디를 가져온다음 store에 입력
        //put()는 인자로 key와 value를 받고 전달된 인자는 HashMap에 key-value 관계로 저장된다.
        //store.put(키값, 데이터);
        return member;
    }

    @Override//인터페이스 구현
    public Optional<Member> findById(Long id) {//id찾기
        return Optional.ofNullable(store.get(id));
        //Optional을 붙이면 id가 null이라도 감싸서 사용할 수 있게 해줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //해당 조건이 될 때 까지
                .filter(member ->member.getName().equals(name)) //filter에 파라미터로 들어오는 name과 같은 것이 있으면 반환
                .findAny();
    }

    @Override
    public List<Member> findAll() {//전부 반환
        return new ArrayList<>(store.values());
    }//implements로 interface MemberRepository를 구현

}
