package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //sequence는 0,1,2.. 키 값을 설정

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //system id 설정
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null일 경우, optional로 감싸서 반환 -> 클라이언트에서 처 리
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //루프를 돌리면서, member.getName이 param으로 넘겨온 name이랑 같은지 확인
        //하나라도 찾으면 반환(findAny)
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member들 반환
    }

    public void clearStore(){
        store.clear();
    }
}
