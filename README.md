# book-review-site

### 메인화면 실행하기
java > main > MainBookList 실행

#### java
[ login ] 

- ajaxtest : 아이디 중복찾기를 위한 서블릿파일  
- checklogin : 로그인 유효성 검사에 사용되는 서블릿파일  
- findid : 아이디를 찾을때 사용되는 서블릿파일  
- findpw : 비밀번호를 찾을떄 사용되는 서블릿파일  
- registeruser : 회원가입시 사용되는 서블릿파일   
- user : 유저를 구성하는 정보 (아이디, 비밀번호, 이름, 전화번호)  
- userdao : 유저 데이터를 다루는 dao 파일  
    - RegisterUser : 유저등록  
    - duplicatedID : 아이디 중복 체크  
    - findid : 아이디 찾기  
    - findpw : 비밀번호 찾기  
    - CheckLogin : 로그인 유효성 체크  
    - dbCon : 데이터 운용을 위한 공통 dbcon  


[ main ]

- Book : 도서정보(코드, 제목, 저자, 출판사 등)  
- BookSelect : 도서선택 했을 때 상세정보를 불러오는 서블릿파일  
- Genre : 장르코드별 장르명 정보  
- GenrePageBooks : 메뉴에서 장르 선택했을 때 장르별 도서 리스트 불러오는 서블릿파일  
- GenrePageBooksAsc : 오름차순으로 도서 리스트 불러오는 서블릿파일  
- GenrePageBooksDesc : 내림차순으로 도서 리스트 불러오는 서블릿파일  
- MainBookList : 메인화면 (장르별로 도서 불러오기)  
- MainDao : 도서, 장르, 리뷰 정보 다루는 dao 파일  
    - getTotal : 페이징을 위한 장르별 도서 개수  
    - descgetPageBooks : 내림차순 리스트 (페이징)  
    - ascgetPageBooks : 오름차순 리스트 (페이징)  
    - getPageBooks : 도서 장르별 리스트 (페이징)  
    - genrename : 장르코드 별 장르 이름 가져오기  
    - genrelist : 장르코드, 장르명 가져오기  
    - mainbooklist : 장르코드별 도서정보 가져오기  
    - dbCon : 데이터 운용을 위한 공통 dbcon  
    - getbook : 도서코드로 해당도서 상세정보 불러오기  
    - searchbook : 책 제목 검색 시 해당 도서 불러오기  
    - insertreview : 한줄평 db에 넣기  
    - getreviews : 저장된 리뷰 도서코드로 불러오기  
    - deletereview : 선택한 한줄평 삭제하기  
- Review : 한줄평 관련 정보  
- ReviewDelete : 한줄평 삭제하는 서블릿파일  
- reviewInsert : 한줄평 작성했을 때 db로 보내고, 리뷰 불러와서 도서 상세정보로 가는 서블릿파일  
- SearchBook : 도서 제목 검색 시 해당도서 불러오는 서블릿파일  

---

#### html
[ darkmode ] 
다크모드

[ findid ] 
아이디 찾기에 관한 html 페이지와 css , js

[ findpw ] 
비밀번호 찾기에 관한 html 페이지와 css , js

[ Register ] 
회원가입에 관한 html 페이지와 css , js

---

#### jsp
[ bookselect ]
- bookselect.css
- bookselect : 도서선택 했을 때 도서 상세 정보화면
- bookselect2 : 도서 검색했을 때 해당 도서 없다는 화면

[ login ] 
- 로그인에 관한 html 페이지와 css , js
- 세션 활용을 위한 세션로그인, 세션로그아웃.jsp파일

[ main ]
- GetPageBooks : 메뉴에서 장르 선택한 화면
- AscGetPageBooks : 오름차순
- DescGetPageBooks : 내림차순
- main : 메인화면

[ Register ] 
- 회원가입 후 완료를 알려주는 html 페이지와 css , js
