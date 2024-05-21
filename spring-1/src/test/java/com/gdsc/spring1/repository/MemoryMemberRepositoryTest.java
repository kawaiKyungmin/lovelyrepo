package com.gdsc.spring1.repository;

import com.gdsc.spring1.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();//Optional 타입에서 가져올려면 get()를 써야 한다.
        //case 1 : System.out.println("result = " + (result == member)); (글자로 보는 기능)
        //Assertions.assertEquals(member, null); //실패
        //case 2 : Assertions.assertEquals(member, result); // junit 진영
        Assertions.assertThat(member).isEqualTo((result));//직관적임 (case 3)
        //member = 기대 값 result = 결과
    }
}
