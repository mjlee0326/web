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
> test method가 끝날 때마다 clear해주는 작업 필요

TTD: 테스트 주도 개발
test cast 먼저 만들고, 그에 맞게 개발


Service class는 비즈니스 의존적 설계
Repository는 기계적으로 단순하게 네이밍
