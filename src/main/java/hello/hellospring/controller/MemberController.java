package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//스프링 컨테이너에서 스프링 빈이 관리됨
//컨트롤러는 어차피 스프링이 관리
@Controller
public class MemberController {
    private final MemberService memberService;

    //스프링 컨테이너에서 memberService를 가져옴
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}