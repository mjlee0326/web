정적 컨텐츠: 서버에서 하는 일 없이 바로 웹 브라우저에 전달
*MVC와 템플릿 엔진*
템플릿엔진(jsp php): 서버에서 프로그래밍해서 동적으로 (렌더링된 html을) 웹 브라우저에 전달
MVC: Model, View, Controller

API: json 데이터 포맷으로 클라이언트에게 데이터 전달


*정적 컨텐츠*

내장 톰캣 서버에서 요청을 받고 controller에서 먼저 hello-static.html이 있는지 확인(우선 순위를 가짐)

없으면 resources에 있는 static/hello-static.html을 찾아서 return

viewResolver: 화면과 관련됨. 뷰를 찾고 템플릿 연결

템플릿엔진이 렌더링을 해서 변환된 html을 웹 브라우저에 전달



@ResponseBody
default: 객체가 오면 json방식으로 데이터를 만들어서, http 응답에 반환

JsonConverter StringConverter

객체를 json으로 바꿔주는 라이브러리 중 대표적: Jackson





컨트롤러: 웹 MVC의 컨트롤러 역할
서비스: 핵심 비즈니스 로직 구현
리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
도메인: 비즈니스 도메인 객체 (eg. 회원 주문, 쿠폰 등 주로 데이터베이스에 저장하고 관리됨)


test 순서는 보장이 되지 않음 (의존 관계 없이 설계)
 test method가 끝날 때마다 clear해주는 작업 필요

TTD: 테스트 주도 개발
test cast 먼저 만들고, 그에 맞게 개발

ctrl + shift + T 하면 바로 test case 생성

Service class는 비즈니스 의존적 설계
Repository는 기계적으로 단순하게 네이밍

DI(Dependency Injection)

DI: 필드 주입, setter 주입, 생성자 주입(권장*)

정형화된 컨트롤러, 서비스, 리포지토리같은 코드는 컴포넌트 스캔을 사용한다.
정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.


요청이 오면, 스프링 컨테이너 안에서 관련 컨트롤러를 찾고, 없으면 static 파일을 찾음

## Model.addAttribute 관련

> Model addAttribute(String name, Object value)

value 객체를 name이름으로 추가한다.
뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용


h2:tcp//localhost/~/test
: 파일 직접 접근이 아니라 소켓을 통해서 접근
: 여러 곳에서 접근 가능:)

### JDBC
자바는 DB랑 붙으려면 이 드라이브가 만드시 있어야 함

alt + insert: generate (파일/디렉토리 새로 생성하는 거랑 단축키 동일)

ctrl + alt + V : 자동으로 리턴값 받을 변수 지정


객체 지향-다형성 활용(interface를 통해서 바꿔끼기) -> spring이 잘되어 있음
기존의 코드는 안 고치고 application을 설정하는 코드(어셈블리)만 건들면 됨

MemberService는 MemberRepository에 의존

MemberRepository는 구현체로 MemoryMemberRepository와 JdbcMemberRepository가 있음

OCP(Open-Closed Priciple): 개방 폐쇄 원칙
: 확장에는 열려있고, 수정, 변경에는 닫혀있다.

스프링의 DI(Dependency Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있음

Database에는 기본적으로 transaction이라는 개념이 존재

@SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.

@Transactional : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고,
테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지
않는다.

#### JdbcTemplate (Jdbc는 실무에서도 많이 사용)

스프링 JdbcTemplate과 MyBatis같은 라이브러리는 JDBC AP에서 본 반복 코드를 대부분 제거해준다. 하지만 SQL은 직접 작성해야 한다.
(eg. 
	conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
이런게 계속 반복되었는데, 이런 것의 반복 코드를 제거해줌)

JDBC 긴 코드를 JDBC Template을 이용해서 확 줄일 수 있음


Alt + enter : replace lambda

#### JPA (interface)
JPA 사용하면 SQL query까지 자동으로 처리

객체 중심 설계 가능

properties에서

spring.jpa.show-sql=true //jpa가 날리는 sql을 볼 수 있음

JPA: 객체와 ORM 기능(Object Relational Mapping)

DB가 id를 자동으로 생성해주는 것을 *identity* 라고 함

JPA를 사용하려면 EntityManager를 주입받아야 한다.


#### Spring Data JPA

interface만 만들어 놓고, spring data가 제공하는 JpaRepository를 extends 해두면, spring data가 interface에 대한 구현체를 알아서 만들고 spring bean에 등록

우리는 injection해서 받을 수 있음

>public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}


#### AOP(Aspect Oriented Programing)
공통 관심 사항과 핵심 관심 사항 분리


슨생님이 가장 좋아하는 단축키

ctrl + alt +  shift + T : inline