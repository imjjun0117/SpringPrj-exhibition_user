# 3조 exhibition 홈페이지 제작
* 사용 언어: Spring, AWS, JSP, Oracle DB, Jquery..
* 제작기간: (2022.05.20~)

## ClassDiagram
<img src="https://user-images.githubusercontent.com/93374409/163676590-f85c0068-d2ae-4eca-92a7-9328433905c1.png"/>



# 개요
오롯이 미술관의 전시 일정을 알려주고, 
예약할 수 있는 웹 사이트가 없다는 점에서 착안
미술관을 찾아헤매는 사람들을 위한 웹사이트


-------------------
## 메인
<img src="https://user-images.githubusercontent.com/93374409/174593330-26141790-09ae-42a6-88e1-290fc897e8ec.png" width="300" height=auto/>

## 로그인, 회원 가입
<img src="https://user-images.githubusercontent.com/93374409/174593749-dfaa069b-67f4-45e7-a31b-42a2b040396a.png" width="500" height=auto/>
<img src= "https://user-images.githubusercontent.com/93374409/174594167-fed48dfb-251c-467c-83ab-6102c71d472f.PNG" width="500" height=auto/>

* Spring Security를 사용하여 처리

-------------------
### 로그인
<img src="https://user-images.githubusercontent.com/93374409/163676765-9d10f7df-4c16-4e24-bc09-054ce2aad4ef.PNG" width="300" height=auto/>

* Login 성공
    * 관리자 계정 : db 조회 성공시 아이디 세션 저장
* Login 실패
    * 실패 시 "로그인 실패!" 메세지 출력 후 로그인창 재호출

-------------------
### DashBoard
<img src="https://user-images.githubusercontent.com/93374409/163676454-48369b71-9de9-4560-bcf2-5aef1ff588fe.PNG"/>

* 총 회원수, 신규 가입회원수
* 전시일정, 예약건 등

### 회원관리


* DB호출 List로 전체 보여준 후 클릭 시 상세 정보 
