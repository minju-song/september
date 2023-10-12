package co.project.prjdb.common;

public class DESC {
//	<Maven Project 생성>
//	-dependency추가
//
//	<외부 라이브러리 추가>
//	1. jsp에 영향을 미치는 것은 lib폴더 안에 .jar로 집어 넣고 build path해줘야함
//	2. java에 영향을 미치는 것은 dependency로 추가
//
//	views 폴더: java를 이 폴더 밑에 넣기 위해 생성
//
//	WEB-INF 는 서버에서 접근하기 때문에 ViewResolve 만들어 줘야함
//
//	<MVC 모델>
//	(MVC들은 VO객체로 전달)
//	model(class로 생성) - (.do로 호출)Controller(Servlet으로 생성) - viewResolve - View(.jsp)
//	*model: service 영역 <-> mapper 영역(구현은 .xml로 생성) (serviceImplt로 연결)
//	*View: Html, css, javaScript, El(${변수}/사칙연산, 관계연산 가능), jsTL
//	1.viewResolve 생성
//	2.business Layor 생성
//	3.servlet과 jsp 작업(보여줄 페이지 만들고 호출명 만들어주고 반복)
//	*전통적인 jsp: Html + java <% %>형식
//	*MVC모델에서 jsp: java코드 빼고 표현부 즉 html로만 작성
//	 servlet을 이용해 모델을 찾고 처리하고 결과를 변환해서 뷰에 던짐 -> Java코드로만 작성
//	 
//	 <jstl>
//	 -표현하는 부에 쓴다
//	 -반복문, 비교문 사용하기 위해 jstl 사용
//	 -외부라이브러리이기 때문에 별도로 설치해야함
//	 -html처럼 태그 작성
//	 -lib에 주입 후 build path에 추가
//	 -core 라이브러리를 주로 사용
//	 -Data 교환은 jstl보다 json방식을 주로 사용
//	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
//	 prefix 라이브러리를 구분하기 위해 사용, 사용자가 직접 만들수도 있음, uri는 core라이브러리를 쓰겠다는 것을 추가, 사용하려는 페이지마다 적어줘야함
//	 <c:if test="" var="" scope="">처리할 내용</c:if>
//	 <c:choose><c:when test=""></c:when><c:otherwise>(default와 동일)</c:otherwise></c:choose>
//	 <c:forEach items="" (begin="" end="" step="") var="" (varStatus="")></c:forEach>
//	 
//	 <Session>
//	 -브라우저를 따라감
//	 
//	 처리
//	 전달할데이터 담음
//	 어느page선택
//	 선택된 페이지 뷰리졸브
//
//	브라우저 -> 서버: 다 String으로 넘김
//
//	<ajax>
//	-비동기 통신
//	-page에서 특정 데이터만 바꾸고 싶을때 사용
//	-.then(결과를 담을 영역).then(처리하는 영역)/.error
//
//	**w3schools.com 홈페이지 참고
//
//	<정리>
//	jsp = web을 만들기위한 종합기술 -> (Html, css, javaScript, EL, jsTL)묶어서 jsp
//	백단은 다 java
//	백단과 jsp를 연결해주는 것이 ViewResolve(request.setAttribute)
//
//	<sql table 생성>
//	-정규화 먼저하고 역정규화(notice테이블에 member id와 name을 같이 집어넣음)
//	이상현상(생성, 수정, 삭제) 방지하려고
//	-전체 테이블과의 관계도 보면서 테이블 생성
//
//	**sql 작성한 부분
//	select * from member;
//	commit;
//	insert into member
//	values ('micol','1234','마이콜','010-1111-1111',SYSDATE);
//	delete from member where member_id='micol';
//
//	SELECT * FROM MEMBER WHERE MEMBER_ID = 'micol';
//
//	update  member set member_password = '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'
//	where member_id = 'kim@yeadam.co.kr';
//
//  파일업로드를 위해 cos, jackson 데이터 처리 jackson databind, 날짜 데이터 처리 jackson datatype
//	Html : String 문자열, file : binary 이진파일, 텍스트가 아닌 파일객체를 쓰려면 enctype을 multipart/form-data로 반드시 변경
//	파일업로드 type file, id와 name은 원본 파일 이름
}
