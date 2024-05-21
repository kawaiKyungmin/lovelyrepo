package com.gdsc.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        //key : "data" data : "hello!!"
        return "hello";
        //hello로 이동
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){//톰캣 서버에서 자동으로 HTML로 변환됨
        //@RequestParam 외부에서 파라미터를 받겠다.
        //http://localhost:8080/hello-mvc?name=spring!!!형식으로 ?를 붙여 파라미터를 외부에서 입력
        model.addAttribute("name",name);//View에 값을 전달
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    //http의 body부에 직접 넣어 주겠다는 뜻
    //데이터를 걍 넘김
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody//반환 타입이 객체라면 JSON 형식으로 반환 문자라면 String으로 변환
    //API제작시 필수로 들어감
    //데이터 교환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }//{name : 'value'}(JSON 스타일)

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
