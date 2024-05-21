package com.gdsc.signin;

import jakarta.persistence.*;

@Entity//프레임 워크
public class Feed {//기본 생성자를 요구함

    public Feed() {
    }

    public Feed(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본키 항목 : 초기화 필요 없음
    private Long id;

    @Column(columnDefinition = "VARCHAR(30)")//제목 30자 내
    private String title;

    @Column(columnDefinition = "VARCHAR(550)")//내용 550자 내
    private String content;
}
