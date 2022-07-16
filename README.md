# book-review-site info

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

---

# DB info (Oracle)


#### 도서 정보 테이블
create  table  book(  
     b_code  varchar2(20)  primary key,  
     b_name  varchar2(100)  not null,  
     author  varchar2(100)  not null,  
     publisher  varchar2(100)  not null,  
     g_code  number(2)  check(g_code in (10,20,30,40,50,60,70,80)),  
     publication_date  date,  
     img  varchar2(100)  not null,  
     b_summary  varchar2(3000)  not null  
);

```plaintext
insert into book values('b1001','파친코1','이민진','문학사상',10,'2018-03-09','http://image.yes24.com/goods/59382261/XL','한국계 1.5세인 미국 작가 이민진의 장편소설 『파친코』 제1권. 내국인이면서 끝내 이방인일 수밖에 없었던 자이니치(재일동포)들의 처절한 생애를 깊이 있는 필체로 담아낸 작품이다. 저자가 자이니치, 즉 재일동포의 존재를 처음 접한 것은 대학생이었던 1989년, 일본에서 자이니치들을 만났던 개신교 선교사의 강연을 들은 때였다. 상승 욕구가 강한 재미동포들과 달리 많은 자이니치들이 일본의 사회적, 경제적 사다리 아래쪽에서 신음하고 있다는 사실을 알게 된 저자는 그때부터 자이니치에 관해 관심을 가지게 되었고 이번 작품에서 일제강점기부터 1980년대까지를 시대적 배경으로 하여 4대에 걸친 핏줄의 역사를 탄생시켰다.');
insert into book values('b1002','테라피스트','B.A.패리스','모모',10,'2021-10-06','http://image.kyobobook.co.kr/images/book/xlarge/518/x9791191043518.jpg','《테라피스트》는 보안이 철저한 만큼 폐쇄적이며, 이웃과 끈끈한 만큼 서로를 감시하는 눈길을 거두지 않는 런던의 고급 주택 단지라는 특수한 배경에서 이야기가 펼쳐진다. 고통스러운 트라우마로 불안정한 심리 상태에 놓인 주인공 앨리스가 겪는 의문의 사건들은 현재와 과거의 시점이 교차하면서 예측하기 힘든 방향으로 천천히 달려간다. 의심과 불안이 극한에 달하는 순간 마주하는 반전은 그간 쌓아온 복선의 설계를 한눈에 파악할 수 있는 통쾌함과 시원함을, 오래 기다렸다 받는 선물처럼 기분 좋게 선사한다.');
insert into book values('b1003','인간 실격','다자이 오사무','민음사',10,'2012-04-10','http://image.kyobobook.co.kr/images/book/xlarge/033/x9788937461033.jpg','오직 순수함만을 갈망하던 여린 심성의 한 젊은이가 인간들의 위선과 잔인함에 의해 파멸되어 가는 과정을 그린 소설.1948년 서른아홉의 나이로 요절하여 일본 사회에 큰 파장을 남긴 일본 현대 문학의 대표적 작가 다자이 오사무의 작품이다. 어떻게든 사회에 융화되고자 애쓰고, 순수한 것, 더럽혀지지 않은 것에 꿈을 의탁하고, 인간에 대한 구애를 시도하던 주인공이 결국 모든 것에 배반당하고 인간 실격자가 되어가는 패배의 기록을 통해 현대 사회를 예리한 고발하고 있다. 함께 실린 직소에서는 유다의 인간적인 측면을 저자만의 독특한 시선으로 새로이 조명하고 있다.');
insert into book values('b1004','위저드 베이커리[개정판]','구병모','창비',10,'2022-03-27','http://image.kyobobook.co.kr/images/book/xlarge/618/x9788936434618.jpg','말을 더듬는 열여섯 살 소년 ‘나’는 어머니가 돌아가신 뒤 재혼한 아버지와 새어머니, 의붓여동생과 함께 살고 있다. 새어머니인 배 선생과 갈등을 겪으며 힘들어하던 ‘나’는 여동생인 무희를 성추행했다는 누명을 쓰고 집에서 도망쳐 나와, 평소 끼니를 해결하고자 자주 들른 ‘위저드 베이커리’에 숨어든다. 급한 마음에 단골 빵집으로 뛰어든 소년이 마주한 것은 놀라운 마법의 세계. 평범한 빵집인 줄로만 알았던 그곳은 사람들의 소원을 이루어 주는 특별한 빵을 만드는 마법사의 베이커리였던 것이다.');
insert into book values('b1005','노르웨이의 숲','무라카미 하루키','민음사',10,'2017-08-07','http://image.kyobobook.co.kr/images/book/xlarge/488/x9788937434488.jpg','독일 함부르크 공항에 막 착륙한 비행기 안에서 울린 비틀스의 《노르웨이의 숲》을 듣고 와타나베는 자신에게 간절한 부탁을 남긴 여자와 그 부탁을 떠올린다. 고등학교 시절 친한 친구 기즈키, 그의 여자 친구 나오코와 언제나 함께였던 와타나베. 그러나 기즈키의 갑작스러운 자살로 행복한 시간은 끝나 버리고 만다. 도쿄의 사립대학에 진학해 고향을 떠나온 와나타베는 나오코와 한동안 연락을 끊고 지내던 어느 날, 자신이 요양원에 들어가 있다는 나오코의 편지를 받게 되는데…….');
insert into book values('b1006','저주토끼','정보라','아작',10,'2022-04-01','http://image.kyobobook.co.kr/images/book/xlarge/665/x9791166686665.jpg','할아버지는 늘 말씀하셨다. “저주에 쓰이는 물건일수록 예쁘게 만들어야 하는 법이다.”대를 이어 저주 용품을 만드는 집안에서 태어난 손자와 그 할아버지의 이야기. 할아버지는 오래 전 젊은 나이에 생을 마감한 친구가 있었다. 할아버지의 친구네 집안은 마을 유지인 술도가. 바른 마음으로 좋은 전통주를 제조해서 팔려고 애쓰는 할아버지 친구네 집안사람들은 그러나 세상 돌아가는 약삭빠른 이치를 깨닫지 못했다. 정부 인사와의 친분, 인물, 접대, 뇌물은 뒷전이고 좋은 술을 만드는 데 전념한 것');

insert into book values('b1007','나에게 고맙다','전승환','북로망스',20,'2022-02-18','http://image.kyobobook.co.kr/images/book/xlarge/072/x9791191891072.jpg','2022년, 7년 만의 전면 개정판으로 선보이는 《나에게 고맙다》에서는 기존 책에 실렸던 사진을 과감히 삭제하고, 아름다운 순간을 포착하는 사진가 빛담(@put_in_light)과의 콜라보레이션을 통해 책의 분위기를 완전히 바꾸어 놓았다. 오래된 글의 일부는 과감히 덜어내고, 요즈음을 살아가는 독자들에게 전하고 싶은 따뜻한 마음을 담은 40여 편의 글을 새로 써 책에 담아냈다.');
insert into book values('b1008','우리는 조구만 존재야','조구만 스튜디오','더퀘스트',20,'2020-12-11','http://image.kyobobook.co.kr/images/book/xlarge/497/x9791165213497.jpg','이 세상의 모든 조구마한 것들에 보내는 따뜻한 찬사! 삐뚤빼뚤 귀여운 그림과 줏대 있는 메시지로 수만 팔로워와 소통하는 조구만 스튜디오의 첫 번째 에세이다. 300만 년이라는 긴 시간 동안 지구 가장자리에서 적당히 살고 있는 공룡 브라키오사우루스 캐릭터를 통해 일상의 여러 면면을 지그시 들여다보는 내용들이 가득 담겨 있다. 자기 자신에 대해, 나를 둘러싼 관계들에 대해, 그리고 인생 전반에 대해 조구만 스튜디오가 이제껏 그 어디에도 공개하지 않았던 내밀한 이야기가 만화, 에세이, 질문의 형태로 제시된다.');
insert into book values('b1009','나만의 순간들','김현경','피카',20,'2022-01-27','http://image.kyobobook.co.kr/images/book/xlarge/282/x9791190299282.jpg','요즘 현대인들의 일과는 이렇습니다. 구독 중인 유튜브로 하루를 시작하고, 짬짬이 SNS에 올라온 지인의 일상과 감정을 들여다보며 때로는 축하를, 때로는 위로와 격려의 댓글을 달며 소통하지요. 그러다 종종 가슴 한구석이 헛헛하고, 온통 화려해 보이는 타인의 일상을 보며 갑자기 자신이 초라하게 느껴지기도 하고요. 한데 타인의 일상을 그토록 열심히 들여다보는 만큼, 나에 대해 궁금했던 적은 있나요? 다른 사람의 일상, 취미, 생각, 감정이 아니라 “온전히 나에게” 묻고 답하는 시간을 가져본 적이 있나요?');
insert into book values('b1010','꽃을 보듯 너를 본다','나태주','지혜',20,'2020-11-30','http://image.kyobobook.co.kr/images/book/xlarge/292/x9791157280292.jpg','블랙핑크(BLACKPINK)의 지수와 세계적인 보컬 그룹인 방탄소년단(BTS)의 RM, 송혜교와 박보검 등은 물론 전국민의 애송시인 [풀꽃]이 수록되어있는 나태주 시집 [꽃을 보듯 너를 본다]. “자세히 보아야/ 예쁘다//오래 보아야/사랑스럽다//너도 그렇다.” 나태주 시인의 [풀꽃]은 전국민의 애송시라고 해도 과언이 아니다. 순수하고 꾸밈없는 시어들은 풀꽃의 시처럼 독자들에게 꾸준히 읽히면 더 큰 사랑을 받게 됐다. 평범한 것에 아름다움을 보는 눈, 별 볼일 없다고 생각했던 무언가를 다시보게 하는 힘이 이 시집에 있다.');
insert into book values('b1011','호호호','윤가은','마음산책',20,'2022-02-05','http://image.kyobobook.co.kr/images/book/xlarge/249/x9788960907249.jpg','좋아하는 게 많은 저자는 과거를 돌아보며 자신이 열광했던 것들에 대한 이야기를 풀어놓는다. 영화, 드라마, 완구, 문구, 꽃, 여름 등 그가 진심으로 좋아했던 것에 대한 이야기를 듣다 보면 좋아하는 마음이 전해진다. 자신을 “진심으로 위로하고 웃게 했던 것”에 바치는 헌사에는 윤가은 영화의 장면을 보는 듯한 어린 시절이 담겨 있기도 하다.');
insert into book values('b1012','소란스러운 동거','박은영','IVP',20,'2022-04-18','http://image.kyobobook.co.kr/images/book/xlarge/259/x9788932819259.jpg','질병과 장애, 몸의 통증을 안고 살아가는 한 장애여성의 일상 모험기. 교육과 노동과 의료 등 삶의 여러 영역에서 ‘정상’이라는 허상에 균열을 내는 다채로운 ‘사이’의 이야기가 펼쳐진다. 좌충우돌하며 살아가는 다른 몸의 이야기는 우리 일상에 깊이 뿌리박힌 차별을 예민하게 감지하게 하고, 누구도 배제하지 않는 새로운 일상을 상상하게 할 것이다.');

insert into book values('b1013','머니 체인저','문준희','마인드셋',30,'2022-04-01','http://image.kyobobook.co.kr/images/book/xlarge/716/x9791191043716.jpg','더 이상 착하게, 꾸준하게, 성실하게 일만 열심히 하는 태도가 경제적인 자유를 보장해주지 않는다. 직장에서 열심히 일하며 내 몸값을 올리더라도 물가 상승률이 훨씬 더 가파르게 상승한다. 그렇기에 우리는 경제와 재테크를 공부해야 한다. 직장에 충성하고 일만 잘하는 것과, 돈의 흐름을 알고 자산을 증식시키는 것은 전혀 다른 문제다. 이 책의 저자도 마찬가지였다. 직장 근처 고시원 생활을 하며 쉬는 날 없이 열심히 일했음에도 불구하고 돈이 모이지 않아 좌절했으며, 첫 월급 83만원을 받으며 생애 내 집 마련은 절대 불가능한 꿈이라 믿었었다.');
insert into book values('b1014','땅,돈,힘','신환종','포레스트북스',30,'2022-04-11','http://image.kyobobook.co.kr/images/book/xlarge/784/x9791191347784.jpg','다양한 방식으로 반복되는 금융위기는 우리에게 매번 많은 가르침을 주고 있다. 1998년 신흥국 외환위기, 2008년 서브프라임발 글로벌 금융위기, 2020년 코로나19 팬데믹은 그동안 경험하지 못했던 위기 상황을 만들어냈다. 시간이 지나고 나서 당시의 상황을 잘 설명한 자료를 통해 뒤돌아본다면 원인과 결과가 명확해 보이지만 위기 발생 상황을 복기한다면 같은 일이 반복된다고 해도 대응하기 쉽지 않다는 것을 알 수 있다. 다시 말해 “시장이 이미 알고 있는 위기는 위기가 아니다”라는 말은 “위기는 진화한다”라는 말과 같은 것이다.');

insert into book values('b1015','마음의 법칙','폴커 키츠, 마누엘 투쉬','포레스트북스',40,'2022-02-10','http://image.kyobobook.co.kr/images/book/xlarge/685/x9791191347685.jpg','독일에서 가장 주목받는 심리학자 듀오답게 저자는 이해하기 어렵거나 낡은 이야기는 빼고, 바로 지금 우리 삶에서 벌어지는 문제와 그 해결책에 주목한다. 면접에서는 심리학의 ‘첫머리 효과’의 ‘최신 효과’를 사용하고 인간관계가 힘들 때는 ‘상호성의 원리’를 이용하는 등 우리가 버겁게 느끼는 일, 사랑, 관계의 문제를 심리학으로 해결한다. 이 책의 독자들은 원하는 것을 얻기 위한 세상에서 가장 강력한 도구를 얻을 수 있을 것이다.');
insert into book values('b1016','사피엔스','유발 하라리','김영사',40,'2015-11-24','http://image.kyobobook.co.kr/images/book/xlarge/464/x9788934972464.jpg','지금으로부터 10만 년 전, 지구에는 호모 사피엔스뿐만 아니라 네안데르탈인, 호모 에렉투스 등 최소 6종의 인간 종이 살아 있었다. 이후 호모 사피엔스 종만이 유일한 승자로 지구상에 살아남게 되었고, 이제 그들은 신의 영역까지 넘보고 있다. 『사피엔스』는 이처럼 중요한 순간을 살고 있는 우리에게 다가올 미래에 대해 어떤 전망이 있는지, 지금이 전망을 가져야 할 때라고 말한다.');

insert into book values('b1017','거꾸로 읽는 세계사','유시민','돌베개','50','2021-10-29','http://image.kyobobook.co.kr/images/book/xlarge/406/x9791191438406.jpg','1988년 초판 출간 이후 스테디셀러로 굳건히 자리를 지켰던 유시민의 『거꾸로 읽는 세계사』가 절판 이후 새 얼굴로 출간됐다. ‘전면개정’이라는 수식이 무색할 정도로 30년 넘게 축적된 정보를 꼼꼼하게 보완하고, 사건에 대한 해석을 바꿨으며, 같은 문장 하나 두지 않고 고쳐 쓴 ‘새로운’ 책이다. 그럼에도 제목을 그대로 쓴 이유는 초판에서 보였던 ‘거꾸로 읽는 자세’를 전부 거둬내지는 않았기 때문이다. 세계를 보는 편향된 시각에 균형을 맞추려 했고, 여전히 소홀하게 취급받는 몇몇 사건도 비중 있게 다뤘다.');
insert into book values('b1018','부의 미술관','니시오카 후미히코','사람과나무사이','50','2022-03-31','http://image.kyobobook.co.kr/images/book/xlarge/603/x9791188635603.jpg','이 책 『부의 미술관』은 ‘메디치 가문 지하 금융의 도움이 없었다면 르네상스도 없었을 것이라는 가정’에서부터 ‘회화가 가진 강력한 프레젠테이션 기능을 간파하고 정치적 선전 도구로 활용한 나폴레옹 이야기’, ‘한때 잡동사니 취급받던 인상주의 회화의 가치를 알아보고 카브리올 레그와 금테 액자를 활용하여 부르는 게 값인 ‘귀하신 몸’으로 둔갑시킨 폴 뒤랑뤼엘의 탁월한 마케팅 전략’ 등 자본주의를 태동시킨 8편의 욕망의 명화 이야기를 다룬다.');

insert into book values('b1019','내 마음을 담은 집','서현','효형','60','2021-01-15','http://image.kyobobook.co.kr/images/book/xlarge/741/x9788958721741.jpg','〈건축, 음악처럼 듣고 미술처럼 보다〉로 인문적 건축서의 새 지평을 연 지, 어언 23년. 자신을 이곳저곳에 다 걸치는 박쥐 같은 성격으로 자리매김하는 저자. 건축가 겸 교수이자 건축 비평가인 그가 직접 지은 작은 집에 관한 이야기를 맛깔스럽게 풀어 놓았다. 건축이 담은 켜켜한 역사성과 치밀한 논리로 탄탄하고 긴박하게 담아낸 기존의 건축서와 다르게 이번엔 감성이 곁들여진 좀 색다른 시각으로 집 짓는 과정을 들려준다. 때론 소담하고 정겨운 듯, 때론 우스꽝스럽고 황당한 에피소드가 곁들여져 술술 읽힌다.');
insert into book values('b1020','농업회계[개정판]','박영일,김혁식','세창문화사','60','2022-05-01','http://image.kyobobook.co.kr/images/book/xlarge/232/x9791191820232.jpg','『농업회계』은 농업경제에 대해 다룬 도서이며 〈회계의 본질〉, 〈농업회계와 회계처리구분〉, 〈재무상태표(대차대조표)의 기본구조 〉 등을 수록하고 있어 기초적이고 전반적인 내용을 확인할 수 있다.');

insert into book values('b1021','브람스의 밤과 고흐의 별','김희경','한국경제신문','70','2022-04-12','http://image.kyobobook.co.kr/images/book/xlarge/987/x9788947547987.jpg','클래식과 미술은 동경하고 친해지고 싶지만 가까워지려면 용기가 필요한 친구 같다. 예술경영을 전공한 문화부 기자이자 영화, 만화 평론가로도 활동 중인 저자는 《브람스의 밤과 고흐의 별》을 통해 클래식 음악 그리고 미술과 진정한 친구가 되는 가장 빠르고 쉬운 길로 독자를 안내한다. 작품 감상과 분석에 앞서 ‘예술가들은 과연 어떤 마음이었을까’ 짐작하며 공감해보는 것, 그리고 그들의 삶과 철학 속으로 성큼 들어가보는 방법이다. 우정을 깊이 나누고자 할 때 먼저 상대의 마음을 헤아리는 게 가장 중요한 것과 다르지 않다.');
insert into book values('b1022','기묘한 미술관','진병관','빅픽시','70','2021-09-08','http://image.kyobobook.co.kr/images/book/xlarge/084/x9791191825084.jpg','시체를 찾기 위해 영안실을 전전하던 화가가 있다면? 16세기에 그려진 늑대 소녀의 초상화가 있다면? 피가 뚝뚝 떨어지는 소의 사체를 그리다가 살해당했다고 소문이 난 화가가 있다면? 우리가 잘 아는 명화들을 들여다보면 보이는 게 전부가 아니라는 것을 알 수 있다. 그저 아름답게 보이지만 사실은 추악한 진실이 숨겨져 있는 그림, 지금은 모두가 칭송하지만 당대에는 철저히 외면당했던 그림, 아직도 숨겨진 비밀을 풀 수 없어 더욱 궁금한 그림….');
insert into book values('b1023','송사비의 클래식 음악야화','송사비','1458music','70','2021-01-28','http://image.kyobobook.co.kr/images/book/xlarge/129/x9791189598129.jpg','천재 작곡가들의 불꽃 같은 사랑과 낭만적 순간에 움튼 아름다운 음악이 한 편의 소설처럼 펼쳐진다. 자극적인의 에피소드를 앞세우기보다 작곡가들의 삶과 그들이 남긴 음악을 제대로 감상할 수 있는 가이드가 되어줄 한 권의 책. 고전 시대부터 현대음악까지, 작곡을 전공한 음악학도가 콕콕 집어주는 쉽고 정확한 해설이 클래식에 성큼 다가서는 즐거움을 선사한다. 부담 없이 책장을 넘기다 보면 어느덧 클래식의 매력에 깊숙하게 빠져든 모습을 발견할 수 있을 것이다.');

insert into book values('b1024','스티커 아트북:랜드마크','콘텐츠기획팀','싸이프레스','80','2017-12-12','http://image.kyobobook.co.kr/images/book/xlarge/367/x9791160320367.jpg','전 세계의 명소 중 우리에게 익숙한 랜드마크 10가지를 한데 모은 『스티커 아트북: 랜드마크』. 별도의 도구 없이 손으로 스티커를 떼어내 붙이기만 하면 되므로 책을 펼칠 공간만 있다면 언제 어디서든 할 수 있는 스티커 아트북이다. 예술 감각이 없다고 고민할 필요도 없다. 지정된 번호에 맞추어 스티커를 붙이기만 하면 색색의 면들이 마치 모자이크처럼 맞춰지며 아름다운 작품이 완성되는 기쁨을 맛볼 수 있다. 누구나 쉽게 도전할 수 있다는 점도 큰 매력이다.');
insert into book values('b1025','사랑스러운 우리집 수세미','서영신,정민선,정지은','경향BP','80','2019-07-05','http://image.kyobobook.co.kr/images/book/xlarge/457/x9788969523457.jpg','각각의 개성이 담긴 작품 세계를 보여주는 3명의 뜨개 디자이너가 또다시 ‘수세미 뜨개 작품’ 책을 완성했습니다. 『주방을 화사하게 바꾸는 우리집 수세미』에 이어서 새로 디자인한 수세미 작품들을 만나보세요. 병아리, 사슴, 판다, 허스키, 플라밍고, 목화, 사과, 복숭아, 새싹, 열기구, 복주머니, 맥주 등 다양한 수세미 도안이 무척 사랑스럽습니다. 같은 모양의 수세미라도 실 색상을 바꾸면 느낌이 달라져 새롭습니다. 빠른 시간에 완성할 수 있는 수세미 뜨개 작품으로 기분도 전환하고 주방도 예쁘게 꾸며보세요.');
insert into book values('b1026','골프 상식사전','김기태','길벗','80','2018-08-10','http://image.kyobobook.co.kr/images/book/xlarge/207/x9791160505207.jpg','골프 왕초보가 알아야 할 골프 규칙과 에티켓부터 초보 골퍼가 싱글 골퍼로 나아가기 위해 놓쳐서는 안 될 여러 팁을 알려주는 『골프 상식사전』. 아마추어 골퍼들은 스윙의 기술에 치중하는 경향이 있는데, 저자는 이 책에서 물리적인 스윙뿐 아니라 멘탈, 흐름 관리, 위기 관리 등에 많은 관심을 기울였다. 실제 필드에서 골프 레슨을 하거나 카페나 팟캐스트 청취자들의 사례, 현장에서 골프 관련 다양한 사람들을 만나며 겪은 사례들을 다양하게 담았다.');

insert into book values('b1027','NFT 현명한 투자자','김동은','알투스','30','2022-02-25','http://image.kyobobook.co.kr/images/book/xlarge/333/x9791186116333.jpg','전)하이브 세계관라이브러리 파트장 김동은 저자의 인문, 기술, 아트, 미래전망을 꿰뚫고 있는 NFT종합서, 저자는 세계관·메타버스·블록체인·암호화폐·NFT까지 이론적 배경지식과 기술적 능력을 가졌고, 실제 NFT 아티스트이며 투자자로도 활동하고 있다. NFT전문가들이 인정한 진짜 전문가이다! 메타버스, NFT는 이 책 한권으로 충분하다!');
```



#### 도서 장르 테이블
create  table  genre(  
     g_code number(2)  check(g_code in (10,20,30,40,50,60,70,80)) primary key,  
     g_name varchar2(50) not null  
);  
```plaintext
insert into genre values(10,'소설');  
insert into genre values(20,'시/에세이');  
insert into genre values(30,'경제');  
insert into genre values(40,'인문');  
insert into genre values(50,'역사/문화');  
insert into genre values(60,'기술');  
insert into genre values(70,'예술');  
insert into genre values(80,'취미');  
```


#### 회원정보 테이블  
CREATE TABLE  sign_up (  
  n_id          VARCHAR2(100) not null PRIMARY KEY,  
  n_pw        VARCHAR2(100) not null,  
  n_name     VARCHAR2(100)  not null,  
  n_tel        VARCHAR2(100) not null  
);


#### 한줄평 테이블  
CREATE TABLE  review (  
  r_num    number(20)  PRIMARY KEY,   
  n_id       VARCHAR2(100) references sign_up(n_id) ,  
  b_code   VARCHAR2(20)  references book(b_code) ,  
  content  VARCHAR2(500) not null,   
  r_date    date   not null                     
);


#### 한줄평 시퀀스  
create sequence re_seq  
start with 1  
increment by 1;  

