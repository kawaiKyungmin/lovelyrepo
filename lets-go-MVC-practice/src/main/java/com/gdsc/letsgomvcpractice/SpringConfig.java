
package com.gdsc.letsgomvcpractice;

import com.gdsc.letsgomvcpractice.repository.MemberRepository;
import com.gdsc.letsgomvcpractice.repository.MemoryMemberRepository;
import com.gdsc.letsgomvcpractice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
        //<직접 빈 지정의 장점>
        //구현체가 바뀌어도 구동 가능
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
