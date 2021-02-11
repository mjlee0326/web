package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.Optional;

//@Service

//회원가입시 필요
//jpa는 join을 할 때의 데이터 변경이 모두 transaction 안에서 실행되어야 함
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

  //  @Autowired
    public MemberService(MemberRepository memberRepository) {
        //외부에서 memberRepository를 넣어줌: DI(Dependency Injection)
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 X

        //ctrl + command + v : auto return
        //optional 안에 member 객체가 있는 구조로, optional을 통한 여러 메소드 이용 가능
        //ctrl + command + M -> Method 만들어줌
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
