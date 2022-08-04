# 3조 exhibition 홈페이지 제작
* 사용 언어: Spring, AWS, JSP, Oracle DB, Jquery..
* 제작기간: (2022.05.20~)
* 링크: http://exhibition.sist.co.kr
<br/>

# 개요
오롯이 미술관의 전시 일정을 알려주고, 
예약할 수 있는 웹 사이트가 없다는 점에서 착안
미술관을 찾아헤매는 사람들을 위한 웹사이트

<br/>
## ClassDiagram

<img src="https://user-images.githubusercontent.com/93374409/163676590-f85c0068-d2ae-4eca-92a7-9328433905c1.png"/>

-------------------
<br/><br/>
# 메인 페이지

<img src="https://user-images.githubusercontent.com/93374409/174593330-26141790-09ae-42a6-88e1-290fc897e8ec.png" width=auto height="800"/>

* 현재 전시 중 가장 예매율 높은 것이 메인 배너로 설정
* 현재 진행 전시 리스트 
* 지역별 전시 진행상황 
-------------------

<br/>
### 로그인, 회원 가입

<img src="https://user-images.githubusercontent.com/93374409/174593749-dfaa069b-67f4-45e7-a31b-42a2b040396a.png"/>
<img src= "https://user-images.githubusercontent.com/93374409/174594167-fed48dfb-251c-467c-83ab-6102c71d472f.PNG"/>

- Spring Security를 사용하여 처리

-------------------
<br/>

### 내 정보

<img src="https://user-images.githubusercontent.com/93374409/174602796-ee4adf42-dd4c-45cd-91f4-b5ca810a5272.png"/>
- 비밀번호 입력 후 일치하면 내 정보 중 예약상황 볼 수 있음
 
-------------------
<br/>

### 전시 예약

<img src="https://user-images.githubusercontent.com/93374409/174603758-2e8b3710-7025-4b35-8b4e-654ea2a643a4.png"/>

- 현재 진행 전시 중 선택 시 위치 자동 변경 
- 방문날짜와 인원 선택 후 예약가능

-------------------
<br/>

### 게시판

<img src="https://user-images.githubusercontent.com/93374409/174604115-9a2fc06f-b227-421e-be11-d87b3ed5e705.png"/>
- 게시글 선택, 카테고리 선택 가능
- 게시글을 작성 후 조회 가능

-------------------
<br/>
<br/>

# 관리자 페이지 
-------------------
<br/>
### 로그인

<img src="https://user-images.githubusercontent.com/93374409/163676765-9d10f7df-4c16-4e24-bc09-054ce2aad4ef.PNG" width="300" height=auto/>

- Login 성공
    - 관리자 계정 : db 조회 성공시 아이디 세션 저장
- Login 실패
    - 실패 시 "로그인 실패!" 메세지 출력 후 로그인창 재호출

-------------------
<br/>
### DashBoard

<img src="https://user-images.githubusercontent.com/93374409/174605919-b50b8086-1721-491b-a0d0-9c8f8b31901e.jpg"/>

- 총 회원수, 신규 가입회원수
- 전시일정, 예약건 등
-------------------
<br/>
### 회원관리, 예약관리, 게시판 관리

<img src="https://user-images.githubusercontent.com/93374409/174604460-d9ced6e3-47e7-4f95-987e-2d7d41aa0e25.jpg"/>

- DB호출 후 회원, 예약, 게시판 관리 가능
- 클릭시 상세정보로 이동
- 회원, 예약, 게시판 글 삭제 가능
- 검색기능 추가

<img src="https://user-images.githubusercontent.com/93374409/174604864-0b9ccf5e-b1e6-411f-bd5e-d83fe9d7876d.jpg"/>

- DB호출 List로 전체 보여준 후 클릭 시 상세 정보 
- 수정 가능
-------------------
<br/>
### 이메일 보내기

<img src="https://user-images.githubusercontent.com/93374409/174604970-015db130-ddae-4e39-94fb-742ec4fd6f57.jpg"/>

- 회원의 이메일(아이디)를 통해 이메일 보내기 기능 추가


----------------
<br/><br/>
## AWS를 통한 서버 올리기

<img src="https://user-images.githubusercontent.com/93374409/174606585-d102d63b-891d-400c-96ea-6d03e990d2b5.png"/>
