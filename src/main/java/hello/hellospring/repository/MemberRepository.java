package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장소에 저장

    Optional<Member> findById(Long id); //null을 optional로 감싸서 반환
    Optional<Member> findByName(String name);

    List<Member> findAll(); //모든 회원 list 반환
}
