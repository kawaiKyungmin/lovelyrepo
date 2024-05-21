package com.gdsc.letsgomvcpractice.repository;


import com.gdsc.letsgomvcpractice.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;//key값 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);//key == sequence, value == member
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //return store.get(id);//id를 가져오겠음(반환 타입에 맞지 않아 오류)
        return Optional.ofNullable(store.get(id));
        //Optional.ofNullable : store.get(id)가 null이라도 오류 없이 반환 가능하게 해줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                    //values() : 벨류를 가지고
                    //stream() : 반복을 돌린다.
                .filter(member -> member.getName().equals(name))
                //필터에 해당되는 값 중
                .findAny();
                //하나를

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //반환 값이 List기 때문에 new ArrayList<>();를 사용하여,
        // 새로운 ArrayList를 만들어준 후
        //그 안에 (store.values())를 넣어 초기화 시켜줌
    }
}
