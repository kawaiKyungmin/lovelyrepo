package com.gdsc.letsgomvc.repository;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;

public class PracticeRepositoryMember implements PracticeRepository{
    //HashMap : key value 형태로 저장됨
    //get(), put()의 형태로 저장과 불러오기를 할 수 있음
    int key = 0;
    HashMap<Integer,String> dabinyee = new HashMap<>();

    @Override
    public String print(Member member) {
        return dabinyee.get(member);
    }

    @Override
    public void input(int key,Member member) {
        dabinyee.put(key, member.getName());
    }
}
