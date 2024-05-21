package com.gdsc.hi.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "practice")
public class PracticeEntity {
    @Id //기본키
    @Column(name = "item_id")//기본키
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;//상품 코드

    @Column(nullable = false, length=50)//상품이름
    private String itemName;

    @Column(name = "price",nullable = false)//가격
    private int price;

    @Column(nullable = false)//재고수량
    private int stockNumber;

    @Lob //일반적인 데이터베이스에서 저장하는 길이인 255개 이상의 문자를 저장하고 싶을 때 지정한다.
    @Column(nullable = false)
    private String itemDetail; //상품설명
}
