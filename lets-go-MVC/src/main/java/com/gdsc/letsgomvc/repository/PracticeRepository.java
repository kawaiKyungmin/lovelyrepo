package com.gdsc.letsgomvc.repository;

import java.lang.reflect.Member;

public interface PracticeRepository {
    String print(Member member);
    void input(int key, Member member);

}
