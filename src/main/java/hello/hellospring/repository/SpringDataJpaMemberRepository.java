package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//interface 다중 상속

//SpringDataJpaMember가 자동으로 구현체를 만들어줌 -> Spring bean에 자동 등록 -> 우린 가져다 쓰기만 하면 됨
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    Optional<Member> findByName(String name);
}
