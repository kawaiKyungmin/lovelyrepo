package com.gdsc.crud.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity//엔티티는 데이터 베이스의 구조를 정의한다
public class EntityCrud {
    public EntityCrud() {
    }

    public EntityCrud(String title, String content) {
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
