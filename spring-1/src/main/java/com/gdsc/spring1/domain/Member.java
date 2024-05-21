package com.gdsc.spring1.domain;

public class Member {
    private Long id;//id식별자 (기본 키)
    private String name;//이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
