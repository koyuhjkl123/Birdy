# <img src="https://github.com/koyuhjkl123/portfolio/assets/94844952/4956f6c6-f49a-4f9b-a7c0-95ce6e4f72c0" width="40" height="40"/> 지식과 정보를 공유하는 조류 포털 Birdy! <br>

 자연과 조화를 이루며 공존하는 새들에 대한 흥미와 참여를 넓히고 새들이 우리 주변에서 <br>
 어떻게 존재하는지를 더 깊이 이해하며 사람들간의 조류에 대해 지식을 공유하는 사이트  <br>
 <br>

# 목차
- 개요
- 서비스 기획 및 방향성 설계
- 프로젝트 구성
- 팀원 및 업무 분담
-  BIRDY핵심기능 설명
-  시연 연상 및 팀원 후기
<br>

# 개요
* 프로젝트 이름 : Birdy!
* 프로젝트 목적 : 사용자가 저희 사이트를 통해 다양한 지식을 소통을 통해 공유하면서 탐조(새를 관찰)를 하기 위한 사이트
* 프로젝트 개발 기간 : 2024.04 ~ 2024.05
* 프로젝트 구성 인원 : 3명
* 프로젝트 개발 환경
  * 언어 : Java 11, HTML/CSS, JavaScript, Python
  * 프레임워크 : Spring Framework, JPA, Spring Security
  * DB : MySQL
  * API 라이브러리 : Jquery, Chart, Gsap, Bootstrap
<br>

# 서비스 기획 및 방향성 설계
프로젝트의 대한 방향성과 기능 설계입니다.

## 요구사항 명세서

<details>
    <summary>보기</summary>

![image](https://github.com/koyuhjkl123/Project_Bridy/assets/94844952/7ccb7fa5-ff97-43f6-92ee-e969c4fcf00c)

</details>

## 프로젝트 일정

<details>
    <summary>보기</summary>

![image](https://github.com/koyuhjkl123/Project_Bridy/assets/94844952/700954bf-f74d-4331-afba-8da8733c9faf)

</details>

## ERD 설계

<details>
    <summary>보기</summary>

![image](https://github.com/koyuhjkl123/Project_Bridy/assets/94844952/1ae06032-5dc8-41d9-9d47-68952298a698)

</details>


# 프로젝트 구성
* 메인 페이지
* 새 앨범
* 커뮤니티 게시판
* 새 뉴스
* 새의 탐조
* 회원가입/로그인
 <br>
 
# 팀원 업무 분담 내역
팀장으로써의 역할을 맡았고 프로젝트 관리 및 일정 조율을 하였습니다. <br>
전반적인 프로젝트의 구성 및 ERD 설계 등 초안을 통해 팀원과 회의를 하였고 시행 착오를 겪으면서 구성하였습니다 <br>
<br>

## <img src="https://github.com/koyuhjkl123/Project_Bridy/assets/94844952/fdf8fb32-8c9f-4859-a343-429eef2b0dd2" width="40" height="40"/>김진수(팀장)
* 담당 역할
  * 전체 페이지 통합 및 구성
    * 카테고리별 메인 페이지 재가공
    * 메인 페이지에 구성에 필요한 카테고리별 페이징 처리
  * ERD, 웹 사이트 기능 설계
  * 새의 통계 및 그래프 시각화
  * 인트로(애니메이션) 기능 구현
  * 새의 뉴스 페이지(일반, 과학) 기능 구현
  * 부트스트랩으로 활용한 화면 구성
 

## <img src="https://github.com/koyuhjkl123/Project_Bridy/assets/94844952/acef5d1e-db23-4245-8ad3-89ce729a4057" width="40" height="40"/>이세진(팀원)
* 담당 역할
  * 회원가입 및 로그인
    * 아이디, 이메일 중복 검사
    * 비빌번호 재확인 검사
    * 이메일 이용한 본인 인증
    * 로그아웃 기능
    * 소셜 로그인(카카오톡)
  * 마이페이지
    * 회원정보 불러오기
    * 개인 정보 수정(비밀번호)
    * 닉네임 수정 시 중복 확인
    * 프로필 사진 업로드 기능
    * 정보 변경 시 업데이트 기능
  * About US
    * 사이트 소개 및 팀원 소개
  * 새의 앨범
    * **"ㄱ, ㄴ, ㄷ"** 모음에 따른 데이터 분류
    * 멸종 위기종 **1급, 2급** 별 분류
    * 새의 사진과 이름, 간략한 설명글 구성

  ## <img src='https://ifh.cc/g/BX1AXr.jpg' width="40" height="40"/>김기윤(팀원)
  * 담당 역할
    * 커뮤니티 게시판
      * 게시글, 댓글 CRUD 구현
      * 게시판 파일 업로드
      * 목록 페이징 처리

      
# Birdy 핵심 기능 설명
저희 사이트 핵심 코드는 "**회원가입/로그인, 카카오API를 활용한 지도 구현, 커뮤니티 게시판, 새의 뉴스, 새의 통계 그래프 시각화, 새의 앨범**" <br>
사용자가 저희 사이트를 통해 다양한 지식을 소통을 통해 공유하면서 탐조(새를 관찰)를 하기 위한 사이트

## 회원가입/로그인
회원가입 양식을 제공하고 새 회원을 등록하고 저장, 이메일 인증처리와 로그인 양식 비밀번호 분실시 변경 양식 제공, 이메일 중복 체크.
Thymeleaf 템플릿 엔진을 사용하여 로그인 페이지를 생성하고, 카카오 로그인 링크와 함께 소셜 로그인 옵션 제공.
<br>

<details>
    <summary>코드 보기(html)</summary>

```html
<!--로그인하기-->
<div layout:fragment="content">
    <form action="/members/login" role="form" method="post">

        <div class="form-group">
            <label th:for="memberEmail">Email</label>
            <input type="email" class="form-control"
                   name="memberEmail" placeholder="이메일을 입력해주세요">
        </div>

        <div class="form-group">
            <label th:for="memberPwd">Password</label>
            <input type="password" id="memberPwd" class="form-control"
                   name="password" placeholder="비밀번호를 입력해주세요">
        </div>

        <!--카카오 로그인-->
        <div class="input-group md-3">
            <a href="/oauth2/authorization/kakao">kakao login</a>
        </div>

        <div>
        <p th:if="${loginErrorMsg}"
           th:text="${loginErrorMsg}" class="error">Error Message!</p>
        <button class="btn btn-primary">로그인</button>
        <button type="button" class="btn btn-primary"
                onclick="location.href='/members/new'">회원가입</button>
        </div>

        <a href="/members/changePassword" rel="external">비밀번호 분실</a>

<!--        <input type="hidden" th:name="${_csrf.parameterName}"-->
<!--               th:value="${_csrf.token}">-->
    </form>
```

</details>


<details>
    <summary>코드 보기(Controller)</summary>

```java

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final LoginService loginService;
    private final EmailService emailService;

    private final PasswordEncoder passwordEncoder;
    private final CertCodeService certCodeService;

    @GetMapping("/new")
    public String memberForm(Model model){
        model.addAttribute("memberFormDTO", new MemberFormDTO());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String newMember(@Valid MemberFormDTO memberFormDTO,
                            BindingResult bindingResult, Model model, MultipartFile profileFile){
        if(bindingResult.hasErrors()){
            System.out.println("-----가입 중 오류 발생-----");
            System.out.println("데이터 확인 : " + memberFormDTO);
            return "member/memberForm";
        }

        try {
            Member member = Member.createMember(memberFormDTO, passwordEncoder);
            loginService.saveMember(member, profileFile);
            System.out.println("저장 완료!");
        }catch(IllegalStateException e){
            model.addAttribute("errorMessage", "이미 가입된 회원입니다.");
            return "member/memberForm";
        }catch(Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println("회원 데이터 저장 중 오류 발생");
            return "member/memberForm";
        }
        return "redirect:/"; // 로그인 성공 후 홈페이지로 리디렉션
    }

    //이메일 인증
    @PostMapping("/cert")
    public ResponseEntity<String> certCode(@RequestBody Map<String, String> requestData){
        String memberEmail = requestData.get("memberEmail");
        if(memberEmail !=null) {
            String certCode = emailService.generateCode();
            System.out.println("------이메일 전달 확인 : " + memberEmail);
            System.out.println("------코드 확인 : " + certCode);
            emailService.sendMail(memberEmail, certCode);
            certCodeService.saveCertCode(memberEmail, certCode);
            System.out.println(memberEmail + "###" + certCode);

            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().body("이메일 주소를 찾을 수 없습니다.");
        }
    }
    @PostMapping("/verify")
    public ResponseEntity<String> verifyCode(@RequestBody Map<String, String> requestData) {
        String memberEmail = requestData.get("memberEmail");
        System.out.println("--------" + memberEmail);
        String certCode = requestData.get("certCode");
        System.out.println("--------" + certCode);
        try {
            loginService.verifyEmail(memberEmail, certCode);
            System.out.println("인증코드 비교 : " + memberEmail + "/" + certCode);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //로그인
    @GetMapping("/login")
    public String loginForm(){
        System.out.println("홈으로 이동");
        return "member/memberLoginForm";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        System.out.println("에러 컨트로러러======");
        model.addAttribute("loginErrorMsg", "이메일, 혹은 비밀번호를 확인해주세요.");
        return "/member/memberLoginForm";
    }

    // 비밀번호 분실시 재설정하기
    @GetMapping("/changePassword")
    public String changePass(Model model){
        model.addAttribute("memberFormDTO", new MemberFormDTO());
        return "member/changePassForm";
    }
    //회원 확인을 위한 이메일 존재 확인
    @PostMapping("/checkEmail")
    public ResponseEntity<Boolean> memberCheck(String memberEmail){
        boolean exists = loginService.memberEmailCheck(memberEmail);
        return ResponseEntity.ok(exists);
    }

    //해당 이메일 회원의 비밀번호 업데이트
    @PostMapping("/changePassword")
    public String pwdUpdate(@RequestParam String memberEmail,
                            @RequestParam String memberPwd,
                            Model model){
        try{
            String newPwd = Member.updatePwd(memberPwd, passwordEncoder);
            loginService.updatePassword(newPwd, memberEmail);
        }catch (Exception e){
            model.addAttribute("errorMessage", "비밀번호 변경 중 오류발생!");
            return "members/changePassForm";
        }
        System.out.println("성공!!");
        return "redirect:/";
    }

    //어바웃 어스 페이지 이동
    @GetMapping("/about")
    public String aboutForm(){
        return "member/about";
    }


}

```

</details>

<details>
    <summary>코드 보기(Service)</summary>

```java

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //마이페이지에 사용자 정보 가져오기(읽기 전용)
    @Transactional(readOnly = true)
    public MemberFormDTO getMemberDtl(String memberEmail) {
        Member member = memberRepository.findByMemberEmail(memberEmail);
        MemberFormDTO memberFormDTO = MemberFormDTO.of(member);
        return memberFormDTO;
    }

    //회원 권한 박탈시키기(STOP: 부여된 권한 없음 = all 허용 가능 외 접근 불가.)
    public void memberStop(Member member){
        if(member != null){
            // id로 회원을 조회해 권한 변경(stop)
            member.setRole(STOP);
            memberRepository.save(member);
        }
    }
    //회원 정보 수정
    public void updateMemberInfo(String memberName, String memberPhone, String memberEmail) throws Exception{
        memberRepository.updateMemberInfo(memberName, memberPhone, memberEmail);
    }

    // 모든 회원 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // ID로 회원 조회
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다: " + id));
    }

    // 회원 정보 업데이트
    public void updateMember(Long id, MemberFormDTO memberFormDTO) {
        Member member = getMemberById(id);
        // MemberFormDTO를 사용하여 업데이트 로직 구현
        // 예: member.setEmail(memberFormDTO.getEmail());
        //    member.setName(memberFormDTO.getName());
        memberRepository.save(member);
    }

    // 회원 삭제(완전삭제)
    public void deleteMember(Long id) {
        Member member = getMemberById(id);
        memberRepository.delete(member);
    }

    public List<Member> searchMembers(String term) {
        // 회원 이름 또는 이메일에 검색어가 포함된 회원을 찾아서 반환
        return memberRepository.findByMemberNameContainingIgnoreCaseOrMemberEmailContainingIgnoreCase(term, term);
    }

    //유저 네임 가져오기
    public String findMemberNameByMemberEmail(String memberEmail) {
        return memberRepository.findMemberNameByMemberEmail(memberEmail);
    }

}

```
</details>

## 카카오 API지도를 활용한 지도 구현
카카오 API를 활용한 지도 위치 서비스 활용 전국 추천 철새 탐조대 구현,
마커 라이브러리 활용 탐조대 마커 표기

<details>
    <summary><i>코드 보기(HTML)</i></summary>
	
```html
	
<!DOCTYPE html>
<html lang="ko" xmlns:th="https://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate='~{layouts/layout1}'>

    <title>탐조</title>
    <th:block layout:fragment="css">
    <style>
        /* 기본 CSS 설정 */
       body, h1, p {
           margin: 0;
           padding: 0;
       }
       .main-box {
           border: 2px solid black;
           padding: 20px;
           margin: 20px;
       }
       .section-box {
           border: 1px solid grey;
           margin: 10px;
           padding: 10px;
           background-color: #f9f9f9;
       }

       /* 헤더 스타일 */
        header {
            background-color: #f8f9fa;
            padding: 20px;
            text-align: center;
            font-size: 24px;
            color: #333;
        }
         /* 버튼 스타일 */
        .bird-button {
            margin: 10px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
        .footer{
            margin-top: 50px;
        }
         .map-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* 전체 뷰포트 높이를 사용 */
    }

    </style>
    </th:block>

    <th:block layout:fragment="script">
        <script th:inline="javascript">
            window.onload = function(){

            var container = document.getElementById('map');
            var options = {
                center: new kakao.maps.LatLng(36.687009,128.046518),
                level: 13
            };
            var map = new kakao.maps.Map(container, options);
		// </맵 생성>

            var positions = [
                {
                    title: '장항습지탐조대',
                    latlng: new kakao.maps.LatLng(37.641278, 126.758219)
                },
                {
                    title: '갯골생태공원탐조대',
                    latlng: new kakao.maps.LatLng(37.392934, 126.776943)
                },
                {
                    title: '명지철새탐조대',
                    latlng: new kakao.maps.LatLng(35.083967, 126.911815)
                },
                {
                    title: '주남저수지탐조대',
                    latlng: new kakao.maps.LatLng(35.310929, 128.680185)
                },
                {
                    title: '간월호철새탐조대',
                    latlng: new kakao.maps.LatLng(36.601085,126.440018)
                },
                {
                    title: '하도철새탐조대',
                    latlng: new kakao.maps.LatLng(33.512076,126.896637)
                },
                {
                    title: '탑립돌보탐조대',
                    latlng: new kakao.maps.LatLng(36.394635, 127.409965)
                }

            ];

            for (var i = 0; i < positions.length; i ++) {

                var marker = new kakao.maps.Marker({  // 마커 생성
                    map: map, // 마커를 표시할 지도
                    position: positions[i].latlng, // 마커를 표시할 위치
                    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시 됨
                });
            }
            }
        </script>
    </th:block>
    <div layout:fragment="content">
        <header>
            <h4> 철새와 탐조  </h4>
        </header>

        <div class="container">
        <div class="main-box">
            <div class="section-box">
                <h1>철새란 무엇인가요?</h1>
                <p>4계절이 있는 우리나라에서는 계절에 따라 다양한 새가 관찰됩니다. 겨울에 따라 이동을 하지 않는 새를 도시새라 하고, 계절에 따라 번식지와 월동지를 이동하는 새를 철새라고 합니다. 철새에는 여름철새, 겨울철새, 동반철새가 있으며, 이외에 길을 잃은 새가 조금합니다.</p>
            </div>
            <div class="section-box">
                <h2>철새와 도시새는 어떻게 구분되나요?</h2>
                <p>철새와 도시새는 번식지와 월동지로 다 그종 이나는 부분에서 차이가 나고 도시화하는 과정에서 발생한 다양한 생활환경에 따라 적응력에 차이가 따라 분류됩니다.</p>
                <p>철새는 사질의 기호와 매이 높고 도시화로부터 상대적으로 먼 지역에서 번식하고, 일부는 양질의 먹이를 찾아 먼 거리를 이동합니다. 반면, 도시새는 인간 주변에서 활동하는 대표적인 새로서 일부는 철새로 변할 수 있습니다.</p>
            </div>
            <div class="section-box">
                <h2>흔히 관찰되는 철새는 무엇인가요?</h2>
                <p>흔히 관찰되는 철새로는 많은 수가 겨울을 채우고 봄에 되면 북상하는 대표적인 겨울철새입니다, 일부는 양질 먹이를 찾아서 거리를 이동합니다. 철새의 양상이나 부류가 다양한 세상에서의 종에서 유형에 따라 분류됩니다.</p>
            </div>
        <h2>전국 추천 탐조대</h2>
        </div>
        <div id="map" style="width: 600px; height: 450px; margin: 0 0 0 20px;"></div>
        <!-- 컨테이너를 추가하여 지도와 목록을 나란히 배치 -->
        <div style="width: 100%; overflow: hidden;">
            <!-- 목록 박스 -->
            <div style="float: right; margin-left: 20px; padding: 20px;
            border: 1px solid #ccc; width: 635px; height: 450px; position: absolute;
            top: 43.8%;
            left: 800px;">
                <h3>탐조대 목록</h3>
                <ol>
                    <li>장항습지탐조대</li><br>
                    <li>갯골생태공원탐조대</li><br>
                    <li>명지철새탐조대</li><br>
                    <li>주남저수지탐조대</li><br>
                    <li>간월호철새탐조대</li><br>
                    <li>하도철새탐조대</li><br>
                    <li>탑립돌보탐조대</li>
                </ol>
            </div>
        </div>

    </div>
    </div>


</html>

```
</details>

<details>
    <summary>코드 보기(Controller)</summary>
	
```java

@GetMapping("/birdy")
    // 새의 탐조
    public String showBirds(@RequestParam(required = false) String type, Model model) {
        List<Birds> birds = birdService.showBirds(type);
        model.addAttribute("birds", birds);
        return "bird/birdybird";
    }
```
		
</details>

<details>
    <summary>코드 보기(Service)</summary>
	
```java

@Service
@RequiredArgsConstructor
public class BirdService {

    private final BirdsRepository birdsRepository;

    public List<Birds> showBirds(String type) {
        List<Birds> birds = type == null ? birdsRepository.findAll() : birdsRepository.findByType(type);
        return birds;
    }
}
```
</details>

## 커뮤니티 게시판
게시판 CRUD구현과, 조회수 처리 Thymeleaf 템플릿 엔진을 사용하여 페이징 처리된 게시글 목록을 표시.

<details>
    <summary>코드 보기(HTML) List</summary>

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="https://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate='~{layouts/layout1}'>

<head>
    <meta name="_csrf" th:content="${_csrf.token}"/>
    <meta name="_csrf_header" th:content="${_csrf.headerName}"/>
    <script th:src="@{/js/board/board_list.js}"></script>
    <link th:href="@{/css/board/board_list.css}" rel="stylesheet">
</head>

    <div layout:fragment="content">

        <div class="container">
            <h1  class="text-center" id="title">자유게시판</h1>
            <form action="/board/list" method="GET" id="search" class="text-center">
                <select id="searchType" name="type">
                    <option value="titleAndContent">제목+내용</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                    <option value="writer">작성자</option>
                </select>
                <input type="text" id="searchKeyword" name="keyword" placeholder="검색어를 입력하세요...">
                <button type="submit" class="btn">검색</button>
    
    
                <a href="/board/insertForm" class="btn"
                th:if="${#authorization.expression('isAuthenticated()')}">자유게시판 작성</a>
            </form>
    
            <p th:if="${keyword}" class="text-center">
                <span th:text="${search}"></span> : <span th:text="${keyword}"></span> 검색 결과입니다</p>
    
                <table class="table table-striped table-bordered text-center">
                    <thead>
                        <tr>
                            <th class="custom-th-width-1">번호</th>
                            <th class="custom-th-width-2">제목</th>
                            <th class="custom-th-width-3">작성자</th>
                            <th class="custom-th-width-4">등록일자</th>
                            <th class="custom-th-width-5">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 최신 공지사항 목록 출력 -->
                        <tr th:each="noticeDTO : ${noticeDTOs}">
                            <td th:text="${noticeDTO.id}"  class="notice"></td>
                            <td  class="notice">
                                <a th:href="@{/noticeDTO/{id}(id=${noticeDTO.id})}" th:text="${noticeDTO.boardTitle}"></a>
                            </td>
                            <td th:text="${noticeDTO.nickName}"  class="notice"></td>
                            <td th:text="${#temporals.format(noticeDTO.regTime, 'yyyy-MM-dd HH:mm:ss')}"  class="notice"></td>
                            <td th:text="${noticeDTO.count}"  class="notice"></td>
                        </tr>
                        
                    
                        <!-- 게시판 목록 출력 -->
                        <tr th:each="board : ${boardPage.content}">
                            <td th:text="${board.id}"></td>
                            <td>
                                <a th:href="@{/board/{id}(id=${board.id})}" th:text="${board.boardTitle}"></a>
                            </td>
                            <td th:text="${board.member.memberName}"></td>
                            <td th:text="${#temporals.format(board.boardCreatedTime, 'yyyy-MM-dd HH:mm:ss')}"></td>
                            <td th:text="${board.count}"></td>
                        </tr>
                    </tbody>
                </table>
                
    
            <div class="pagination">
                <ul>
                    <li th:if="${boardPage.hasPrevious()}">
                        <a th:href="@{/board/list/(page=${boardPage.number - 1}, size=${boardPage.size})}">&laquo; 이전</a>
                    </li>
                    <li th:each="pageNumber : ${#numbers.sequence(0, boardPage.totalPages - 1)}" th:class="${boardPage.number == pageNumber} ? 'active'">
                        <a th:href="@{/board/list/(page=${pageNumber}, size=${boardPage.size})}" th:text="${pageNumber + 1}"></a>
                    </li>
                    <li th:if="${boardPage.hasNext()}">
                        <a th:href="@{/board/list/(page=${boardPage.number + 1}, size=${boardPage.size})}">다음 &raquo;</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>

</div>

</html>
```
</details>

<details>
    <summary>코드 보기(Controller)</summary>

```java
package com.keduit.bird.controller;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.BoardNoticeDTO;
import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.BoardNoticeRepository;
import com.keduit.bird.repository.MemberRepository;
import com.keduit.bird.service.BoardNoticeService;
import com.keduit.bird.service.BoardService;
import com.keduit.bird.service.CommentService;
import com.keduit.bird.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Sort;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final MemberRepository memberRepository;
    private final BoardNoticeService boardNoticeService;

    @GetMapping("/insertForm")
    public String saveForm(Principal principal){
        String email = principal.getName();
        Member member = memberRepository.findByMemberEmail(email);
        if(member == null){
//           만약에 시큐리티에서도 했지만 한번 더 확인
            return "/members/login";
        }
        if(member.getRole().equals(Role.STOP)){
//           정지된 사람도 다시 로그인 페이지로 이동
            return "/members/login";
        }
        return "save";
    }
    //작성자를 해당 유저의 이름으로 자동적용시키기위해 코드 추가함.

    @PostMapping("/save")
    public ResponseEntity<String>  boardInsert(@RequestParam("boardTitle") String title,
                       @RequestParam("boardContent") String content,
                       @RequestParam("boardImgFile") List<MultipartFile> imgFiles,
                       Principal principal) throws Exception{
    String email = principal.getName();
    Member member = memberRepository.findByMemberEmail(email);
    if (member == null) {
        System.out.println("데이터베이스에 없는 회원입니다.");
         return new ResponseEntity<>("데이터베이스에 없는 회원입니다.", HttpStatus.NOT_FOUND);
    }
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setBoardTitle(title);
    boardDTO.setBoardContent(content);
    boardDTO.setEmail(email);
    try {
        boardService.insertBoard(boardDTO, imgFiles, email);
    } catch (Exception e) {
        System.out.println("게시물을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        return new ResponseEntity<>("게시물을 저장하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>("게시물이 성공적으로 저장되었습니다.", HttpStatus.OK);
}



    @GetMapping({"/list","/list/{requestData}"})
    public  String boardList( @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(required = false) String type,
                             @RequestParam(required = false) String keyword,
                            Model model){
        String search = "";
        List<BoardNoticeDTO> noticeDTOs = boardNoticeService.getTopBoardNotice();
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Board> boardPage = boardService.getBoardPage(pageable, type, keyword);

        

        if ("titleAndContent".equals(type)) {
            search = "제목+내용";
        } 
        if ("title".equals(type)) {
            search = "제목";
        }
        if ("content".equals(type)) {
            search = "내용";
        }
        if ("writer".equals(type)) {
            search = "작성자";
        } 
        model.addAttribute("noticeDTOs", noticeDTOs);
        model.addAttribute("search", search);
        model.addAttribute("keyword", keyword);
        model.addAttribute("boardPage", boardPage);
        return "paging";
    }
    

    @GetMapping("/{id}")
    public String oneBoard(@PathVariable("id") Long boardId, Model model,
                            HttpServletRequest request, HttpServletResponse response){

        System.out.println("하나조회 컨트롤러왔음");
        
        List<CommentDTO> commentDTOs = commentService.getBoardComment(boardId);
        BoardDTO boardDTO = boardService.getOneBoard(boardId);



             // Check if the board was visited
        Cookie[] cookies = request.getCookies();
        boolean visited = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Check if the visited cookie for the specific boardId exists
                if (cookie.getName().equals("visited_" + boardId)) {
                    visited = true;
                    break;
                }
            }
        }

        // Increase view count if not visited
        if (!visited) {
            boardService.increaseViewCount(boardId);

            // Set cookie to mark the board as visited
            Cookie cookie = new Cookie("visited_" + boardId, "true");
            cookie.setMaxAge(24 * 60 * 60); // 24 hours
            cookie.setPath("/"); // Cookie is valid for the entire site
            response.addCookie(cookie);
        }

        model.addAttribute("commentDTOs", commentDTOs);
        model.addAttribute("boardDTO", boardDTO);

        return "detail";
    }


    @GetMapping("update/{boardid}")
    public String boardUpdateForm(@PathVariable("boardid") Long boardId,Model model){

        System.out.println("수정 페이지 이동");
        BoardDTO boardDTO = boardService.getOneBoard(boardId);
        model.addAttribute("boardDTO", boardDTO);

        return "update";
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable Long id,
                                              @ModelAttribute BoardDTO boardDTO,
                                              @RequestParam("boardImgFile") List<MultipartFile> boardImgFile,
                                              Principal principal) {
        System.out.println("수정컨트롤러 도착" + boardDTO.toString());
   // 파일의 사이즈를 출력
        System.out.println("파일 사이즈: " + boardImgFile.get(0).getSize() + " bytes");
        // 파일의 원본 이름을 출력
        System.out.println("원본 파일 이름: " + boardImgFile.get(0).getOriginalFilename());
        // 파일의 콘텐츠 타입을 출력
        System.out.println("파일 콘텐츠 타입: " + boardImgFile.get(0).getContentType());
        
        // 파일의 저장 이름을 출력 (필요하다면)
        System.out.println("파일 저장 이름: " + boardImgFile.get(0).getName());
        // 존재 유무
        System.out.println("비어있는 유무1"+boardImgFile.isEmpty());
        System.out.println("비어있는 유무2"+boardImgFile.get(0).isEmpty());
        String email = principal.getName();
        Member member = memberRepository.findByMemberEmail(email);
        if (member == null) {
            return new ResponseEntity<>("데이터베이스에 없는 회원입니다.", HttpStatus.NOT_FOUND);
        }
        try {
            System.out.println("수정컨트롤러 try");
            boardService.boardUpdate(boardDTO, boardImgFile, email);
        } catch (Exception e) {
            return new ResponseEntity<>("게시물을 수정하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("게시물이 성공적으로 수정되었습니다.", HttpStatus.OK);
    }


    @DeleteMapping("/delete/{boardid}")
    public ResponseEntity<String> boardDelete(@PathVariable("boardid") Long boardId,
                              @RequestBody Map<String, String> requestData,Principal principal){

        try {
            System.out.println("삭제 컨트롤러왔씀");
            System.out.println("삭제 boardId"+boardId);

            String email = principal.getName();
            boardService.boardDelete(boardId, email);
        } catch (Exception e) {
            // alert에서 뜨는 메세지는 서비스에서 구현
            return new ResponseEntity<>("게시물을 수정하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("게시물이 성공적으로 수정되었습니다.", HttpStatus.OK);
    }





}

```
</details>

<details>
    <summary>코드 보기(Service)</summary>

```java
package com.keduit.bird.service;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.entity.BoardNotice;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.BoardImgRepository;
import com.keduit.bird.repository.BoardRepository;
import com.keduit.bird.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardImgService boardImgService;
    private final MemberRepository memberRepository;
    private final BoardImgRepository boardImgRepository;

    public Long insertBoard(BoardDTO boardDTO, List<MultipartFile> boardImgFileList,String email) throws Exception {
  
        Member member = memberRepository.findByMemberEmail(email);

//      컨트롤러에서 확인했지만 한번더 확인
        if(member == null){
            throw new UsernameNotFoundException("해당하는 이메일(" + email + ")을 찾을 수 없습니다.");
        }
        if(member.getRole().equals(Role.STOP)){
          throw new IllegalStateException("해당하는 이메일(" + email + ")을 정지된 회원입니다.");
        }
        Board board = new Board();
        board.setBoardContent(boardDTO.getBoardContent());
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setMember(member);
        boardRepository.save(board);
        for (int i = 0; i < boardImgFileList.size(); i++) {
            BoardImg BoardImg = new BoardImg();
            BoardImg.setBoard(board);
            boardImgService.saveCommunityImg(BoardImg, boardImgFileList.get(i));
        }
        return board.getId();
    }


    public List<BoardDTO> getBoardList(){
        List<Board> boardList = boardRepository.findAll();


        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board : boardList) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(board.getId());
            boardDTO.setNickName(board.getMember().getMemberName());
            boardDTO.setBoardTitle(board.getBoardTitle());
            boardDTO.setBoardContent(board.getBoardContent());
            boardDTO.setCount(board.getCount());
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }




public Page<Board> getBoardPage(Pageable pageable, String type, String keyword) {
    System.out.println("서비스 코드 도착");
    System.out.println("keyword"+keyword);
    
    if ("titleAndContent".equals(type)) {
        System.out.println("첫번째 문");
        return boardRepository.findFilterBoard(keyword, pageable);
    } else if ("title".equals(type)) {
        System.out.println("2번째 문");
        return boardRepository.findByBoardTitleContaining(keyword, pageable);
    } else if ("content".equals(type)) {
        System.out.println("3번째 문");
        return boardRepository.findByBoardContentContaining(keyword, pageable);
    } else if ("writer".equals(type)) {
        System.out.println("4번째 문");
        return boardRepository.findByMemberNameContaining(keyword, pageable);
    } else {
        System.out.println("마지막");
        return boardRepository.findAll(pageable);
    }
}


public BoardDTO getOneBoard(Long boardId) {

    BoardDTO boardDTO = new BoardDTO();
    // 게시글 찾기
    Board board = boardRepository.findById(boardId).orElse(null);

    // 이미지 찾기
    BoardImg boardImg = boardImgRepository.findByBoardId(boardId);

    // 게시글 내용이 있다면
    if (board != null) {
        boardDTO.setId(boardId);
        boardDTO.setEmail(board.getMember().getMemberEmail());
        boardDTO.setBoardTitle(board.getBoardTitle());
        boardDTO.setBoardContent(board.getBoardContent());
        boardDTO.setNickName(board.getMember().getMemberName()); 
        boardDTO.setRegTime(board.getBoardCreatedTime());
        boardDTO.setUpdateTime(board.getBoardUpDatedTime());
        boardDTO.setCount(board.getCount());

        if(boardImg !=null){
            if (!boardImg.getImgName().equals("")) {
                boardDTO.setFileName(boardImg.getImgName());
                boardDTO.setImgUrl(boardImg.getImgUrl());
                boardDTO.setOriImgName(boardImg.getOriImgName());
            }
        }
    // 게시글이 없다면
    } else {
        throw new RuntimeException("게시물을 찾지 못하였습니다. " + boardId);
    }
    return boardDTO;
}



public void boardUpdate(BoardDTO boardDTO, List<MultipartFile> boardImgFileList, String email) throws Exception {
    System.out.println("서비스 업데이트 도착");
    System.out.println("서비스 업데이트 boardDTO" + boardDTO.toString());
    System.out.println("서비스 업데이트 boardImgFileList++++" + boardImgFileList.isEmpty());
    Member member = memberRepository.findByMemberEmail(email);
    Board board = boardRepository.findById(boardDTO.getId()).orElse(null);
    BoardImg boardImg = boardImgRepository.findByBoardId(board.getId());

    if (member == null) {
        throw new UsernameNotFoundException("회원가입을 해주시기 바랍니다");
    }
    if (board == null) {
        throw new IllegalArgumentException("게시글을 찾을 수 없습니다");
    }
    // 작성자와 수정자 비교, 관리자라면 수정 가능
    if (!board.getMember().getMemberEmail().equals(email) && member.getRole() != Role.ADMIN) {
        throw new SecurityException("해당 게시글을 수정할 권한이 없습니다.");
    }

    // 이미지 삭제 로직
    if (boardDTO.isDeleteImg()) {
        System.out.println("이미지 삭제 조건문");
        boardImgRepository.delete(boardImg);
    } 
    // 하나의 이미지만 받아서 첫번쨰 자리로 해결  boardImgFileList.isEmty() 파일 존재 자체 유무를 판단한다고함.
    else if (!boardImgFileList.get(0).isEmpty()) {
        System.out.println("이미지 파일 리스트가 비어 있지 않음");
        // 기존 이미지 삭제 및 새로운 이미지 저장
        if (boardImg != null) {
            System.out.println("기존 이미지 삭제");
            boardImgRepository.delete(boardImg);
        }
        for (int i = 0; i < boardImgFileList.size(); i++) {
            BoardImg BoardImg = new BoardImg();
            BoardImg.setBoard(board);
            boardImgService.saveCommunityImg(BoardImg, boardImgFileList.get(i));
        }
    }

    // 게시글 정보를 업데이트
    board.setMember(member);
    board.setBoardTitle(boardDTO.getBoardTitle());
    board.setBoardContent(boardDTO.getBoardContent());
    boardRepository.save(board);
}




public void boardDelete(Long boardId, String email) {
    System.out.println("삭제");
    // boardId와 email로 보드를 찾습니다.
    Board board = boardRepository.findById(boardId).orElse(null);
    Member member = memberRepository.findByMemberEmail(email);
    BoardImg boardImg = boardImgRepository.findByBoardId(boardId);
    if (member == null) {
        throw new UsernameNotFoundException("회원가입을 해주시기 바랍니다");
    }
    if (board == null) {
        throw new IllegalArgumentException("게시글을 찾을 수 없습니다");
    }
       // 작성자와 수정자 비교, 관리자라면 수정 가능
    if (!board.getMember().getMemberEmail().equals(email) && member.getRole() != Role.ADMIN) {
        throw new SecurityException("해당 게시글을 수정할 권한이 없습니다.");
    }
    /// 게시글 삭제
    boardRepository.delete(board);

    if(boardImg != null){
        boardImgRepository.delete(boardImg);
    }
    // 이미지삭제

}



    public Board increaseViewCount(Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);

        // 조회수를 1 증가시킵니다.
        board.setCount(board.getCount() + 1);

        // 증가된 조회수를 저장하고 업데이트된 BoardCommunity 객체를 반환합니다.
        return boardRepository.save(board);
    }

//내가 쓴 글 찾기(mpage 기능)
    public List<Board> getBoardsByCurrentMember(String memberName) {
        return boardRepository.findByMemberName(memberName);
    }

}



```
</details>

## 새의 뉴스
크롤링을 활용한 NEWS 게시판, (크롤링->엑셀->데이터베이스), 새로운 뉴스 지난 뉴스 ,과학 뉴스카테고리 분류 구현.

<details>
    <summary>코드 보기(HTMl)</summary>

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="https://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate='~{layouts/layout1}'>


    <title>News Page</title>
    <th:block layout:fragment="css">
    <style>
        .news-box {
            float: left; /* 왼쪽 또는 오른쪽 정렬을 위해 float 사용 */
            width: 50%; /* 화면의 절반 크기 */
            padding: 10px;
            box-sizing: border-box;

        }
        .full-width {
            width: 100%; /* 전체 폭 사용 */
            clear: both; /* 이전 float 제거 */
        }
        .left {
            float: left; /* 왼쪽 정렬 */
        }
        .right {
            float: right; /* 오른쪽 정렬 */
        }
        .content{
            height: 1500px;
        }
        .past_page, .science_news{
            width: 500px;
            margin-left: 20px;

        }
        .news_page{
            width: 500px;
            margin-left: 270px;
        }
        .science, .news, .past{
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        .new-news, .past-news, .science-news{
            text-align: center;
        }
        .science p, .news p, .past p,
        .science h3, .news h3, .past h3{
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</th:block>

<div layout:fragment="content">
    <div class="container">
        <div class="news-box right new-news full-width">
            <h2>New News</h2>
            <ul class="news_page">
                <li th:each="news : ${newNews}" class="news">
                    <a th:text="${news.birdysNewsTitle}" th:href="${news.birdysNewsSource}" style="text-decoration: none; font-size: 20px;"></a>
                    <p th:text="${news.birdysNewsContent}"></p>
                </li>
            </ul>
            <!-- New News 페이지 번호 표시 -->
            <div th:if="${newNews.totalPages > 1}">
                <ul class="pagination justify-content-center">
                    <!-- 처음으로 버튼 -->
                    <li th:class="${newNews.first ? 'disabled' : ''}" th:unless="${newNews.first}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=0'}">처음으로</a>
                    </li>
                    <!-- 이전 버튼 -->
                    <li th:class="${newNews.hasPrevious() ? '' : 'disabled'}" th:unless="${newNews.first}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + ${newNews.number - 1}}">이전</a>
                    </li>
                    <!-- 페이지 번호 -->
                    <li th:each="i : ${#numbers.sequence(0, newNews.totalPages - 1)}" th:class="${newNews.number == i ? 'active' : ''}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + ${i}}">[[${i + 1}]]</a>
                    </li>
                    <!-- 다음 버튼 -->
                    <li th:class ="${newNews.hasNext() ? '' : 'disabled'}">
                        <a class="btn btn-primary btn-sm" th:if="${newNews.hasNext()}" th:href="@{'/news?page=' + ${newNews.number + 1}}">다음</a>
                    </li>
                    <!-- 끝 버튼 -->
                    <li th:class="${newNews.last ? 'disabled' : ''}" th:unless="${newNews.last}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + (${newNews.totalPages} - 1)}">끝</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="news-box left past-news">
            <h2>Past News</h2>
            <ul class="past_page">
                <li th:each="news : ${pastNews}" class="past">
                    <a th:text="${news.birdysNewsTitle}" th:href="${news.birdysNewsSource}" style="text-decoration: none; font-size: 20px;"></a>
                    <p th:text="${news.birdysNewsContent}"></p>
                    <p th:text="${news.birdysNewsSource}"></p>
                </li>
            </ul>
            <!-- Past News 페이지 번호 표시 -->
            <div th:if="${pastNews.totalPages > 1}">
                <ul class="pagination justify-content-center">
                    <!-- 처음으로 버튼 -->
                    <li th:class="${pastNews.first ? 'disabled' : ''}" th:unless="${pastNews.first}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=0'}">처음으로</a>
                    </li>
                    <!-- 이전 버튼 -->
                    <li th:class="${pastNews.hasPrevious() ? '' : 'disabled'}" th:unless="${pastNews.first}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + ${pastNews.number - 1}}">이전</a>
                    </li>
                    <!-- 페이지 번호 -->
                    <li th:each="i : ${#numbers.sequence(0, pastNews.totalPages - 1)}" th:class="${pastNews.number == i ? 'active' : ''}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + ${i}}">[[${i + 1}]]</a>
                    </li>
                    <!-- 다음 버튼 -->
                    <li th:class ="${pastNews.hasNext() ? '' : 'disabled'}">
                        <a class="btn btn-primary btn-sm" th:if="${pastNews.hasNext()}" th:href="@{'/news?page=' + ${pastNews.number + 1}}">다음</a>
                    </li>
                    <!-- 끝 버튼 -->
                    <li th:class="${pastNews.last ? 'disabled' : ''}" th:unless="${pastNews.last}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + (${pastNews.totalPages} - 1)}">끝</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="news-box right science-news">
            <h2>Science News</h2>
            <ul class="science_news">
                <li th:each="science : ${scienceNews}" class="science">
                    <a th:text="${science.birdysScienceonTitle}" th:href="${science.birdysScienceonSource}" style="text-decoration: none; font-size: 20px;"></a>
                    <p th:text="${science.birdysScienceonContent}"></p>
                    <p th:text="${science.birdysScienceonSource}"></p>
                </li>
            </ul>
            <!-- science News 페이지 번호 표시 -->
            <div th:if="${scienceNews.totalPages > 1}">
                <ul class="pagination justify-content-center">
                    <!-- 처음으로 버튼 -->
                    <li th:class="${scienceNews.first ? 'disabled' : ''}" th:unless="${scienceNews.first}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=0'}">처음으로</a>
                    </li>
                    <!-- 이전 버튼 -->
                    <li th:class="${scienceNews.hasPrevious() ? '' : 'disabled'}" th:unless="${scienceNews.first}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + ${scienceNews.number - 1}}">이전</a>
                    </li>
                    <!-- 페이지 번호 -->
                    <li th:each="i : ${#numbers.sequence(0, scienceNews.totalPages - 1)}" th:class="${scienceNews.number == i ? 'active' : ''}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + ${i}}">[[${i + 1}]]</a>
                    </li>
                    <!-- 다음 버튼 -->
                    <li th:class ="${scienceNews.hasNext() ? '' : 'disabled'}">
                        <a class="btn btn-primary btn-sm" th:if="${scienceNews.hasNext()}" th:href="@{'/news?page=' + ${scienceNews.number + 1}}">다음</a>
                    </li>
                    <!-- 끝 버튼 -->
                    <li th:class="${scienceNews.last ? 'disabled' : ''}" th:unless="${scienceNews.last}">
                        <a class="btn btn-primary btn-sm" th:href="@{'/members/news?page=' + (${scienceNews.totalPages} - 1)}">끝</a>
                    </li>
                </ul>
            </div>
        </div>
        </div>
    </div>
</div>


</html>


```
</details>

<details>
    <summary>코드 보기(Controller)</summary>

```java
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final ScienceonService scienceonService;

    @GetMapping("/news")
    public String showNews(Model model, @RequestParam(defaultValue = "0") int newPage, @RequestParam(defaultValue = "0")
                           int pastPage, @RequestParam(defaultValue = "0") int scienceonPage) {

        // 최신 뉴스 페이징 처리
        Page<NewsDTO> latestNews = newsService.findLatestNews(newPage, 3);
        model.addAttribute("newNews", latestNews);
        model.addAttribute("newPage", newPage);
        model.addAttribute("hasNextNewPage", latestNews.hasNext());


        // 과거 뉴스 페이징 처리
        Page<NewsDTO> pastNews = newsService.findPastNews(pastPage, 5);
        model.addAttribute("pastNews", pastNews);
        model.addAttribute("pastPage", pastPage);
        model.addAttribute("hasNextPastPage", pastNews.hasNext());

        
        // 과학 뉴스
        Page<ScienceDTO> scienceNews = scienceonService.findScienceNews(scienceonPage, 5);
        model.addAttribute("scienceNews", scienceNews);
        model.addAttribute("sciencePage", scienceonPage);
        model.addAttribute("hasNextSciencePage", scienceNews.hasNext());
        return "member/news";
    }
}
```
</details>

<details>
    <summary>코드 보기(Service)</summary>

```java
@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<NewsDTO> findAllNews() {
        // 모든 뉴스 정보 가져오기
        return newsRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    // 페이징 처리된 최신 뉴스 정보 가져오기
    public Page<NewsDTO> findLatestNews(int page, int size){

        return newsRepository.findAllByOrderByBirdysNewsRegisterDateDesc(PageRequest.of(page,size)).map(this::convertEntityToDTO);
    }

    // 페이징 처리된 과거 뉴스 정보 가져오기
    public Page<NewsDTO> findPastNews(int page, int size){

        return newsRepository.findAllByOrderByBirdysNewsRegisterDateAsc(PageRequest.of(page,size)).map(this::convertEntityToDTO);
    }

    public NewsDTO convertEntityToDTO(News news) {
        // 가져온 데이터를 DTO에 있는 필드을 저장한 후 DTO를 리턴
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setBirdysNewsId(news.getBirdysNewsId()); // Id
        newsDTO.setBirdysNewsTitle(news.getBirdysNewsTitle()); // 뉴스 제목
        newsDTO.setBirdysNewsContent(news.getBirdysNewsContent()); // 뉴스 내용
        newsDTO.setBirdysNewsSource(news.getBirdysNewsSource()); // 뉴스 URL
        newsDTO.setBirdysNewsRegisterDate(news.getBirdysNewsRegisterDate()); // 뉴스 등록 일자
        return newsDTO;
    }
}
```
</details>

## 메인 페이지 및 새의 통계 및 그래프 시각화
공공API를 활용한 새의 통계, 커뮤니티 게시판, 새의 통계 데이터를 가져오고 맵 형태로 화면에 반환 페이징 처리하여 메인 화면에 구현.

<details>
    <summary>코드 보기(HTMl)</summary>

```html
<!doctype html>
<html lang="ko" xmlns:th="https://thymeleaf.org"
	  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	  layout:decorate='~{layouts/layout1}'>
<th:block layout:fragment="script">

	<script th:inline="javascript">


      const token = $("meta[name='_csrf']").attr("content");
      const header = $("meta[name='_csrf_header']").attr("content");

	document.addEventListener('DOMContentLoaded', function () {
      // 페이지 로드 시 초기 데이터를 가지고 그래프를 그립니다.
 /*<![CDATA[*/
    const birdLabels = /*[[${birdLabels}]]*/ [];
    const birdData = /*[[${birdData}]]*/ [];

	 /*]]>*/

    let birdChart = new Chart(document.getElementById("bird-chat"), {
        type: 'bar',
        data: {
            labels: birdLabels,
            datasets: [{
                label: '개체수',
                data: birdData,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
    });
		// 페이지 이동 시에 호출되는 함수
    function updateBirdChart(birdData) {
        // 새로운 데이터로 그래프를 업데이트합니다.
        var birdLabels = Object.keys(birdData);
        var birdCounts = Object.values(birdData);

        birdChart.data.labels = birdLabels;
        birdChart.data.datasets[0].data = birdCounts;
        birdChart.update();
    }


	</script>
</th:block>
<th:block layout:fragment="css">
	<style>
		.intro {
    position: fixed;
    display: grid;
    place-items: center;
    height: 100vh;
    width: 100%;
    background-color: white;
    z-index: 1115;
  }

  .intro__title {
    color: white;
    font-family: Arial, Helvetica, sans-serif;
    max-width: 75%;
    text-align: center;
    line-height: 85px;
    font-size: 40px;
    mix-blend-mode: difference;
    z-index: 2;
    transform: translateY(40px);
  }

  .intro__background {
    position: absolute;
    top: 0;
    background-color: black;
    width: 50%;
    height: 100%;
    transform: scaleX(0);
  }

  .intro__background--left {
    left: 0;
    transform-origin: left center;
  }

  .intro__background--right {
    left: 50%;
    transform-origin: right center;
  }
		.science, .news, .past, .meta{
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        .new-news, .past-news, .science-news{
            text-align: center;
        }
        .science p, .news p, .past p,
        .science h3, .news h3, .past h3, .meta span{
            overflow: hidden;
            text-overflow: ellipsis;
        }

	</style>
</th:block>
<div layout:fragment="content">
	<!-- Start Hero Section -->
	<div class="hero">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-5">
					<div class="intro-excerpt">
						<h1>새의 아름다움과<span class="d-block">지식 공간</span></h1>
						<p class="mb-4">새의 통계와 커뮤니티를 제공하여 <br>다양한 사람들과 함께 지식을 공유하는 공간입니다."</p>
						<p><a th:href="@{/bird/birds}" class="btn btn-secondary me-2">새의 앨범</a><a th:href="@{/board/list}" class="btn btn-white-outline">커뮤니티</a></p>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="hero-img-wrap">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Hero Section -->

	<!-- Start Product Section -->
	<div class="product-section">
		<div class="container">
			<div class="row">
				<!-- Start Column 1 -->
				<div>
					<h2 class="mb-4 section-title center">새의 통계</h2>
					<p class="mb-4 center">2019년 새의 개체수</p>
					<!--						<p><a href="shop.html" class="btn">Explore</a></p>-->
				</div>
				<canvas id="bird-chat" width="1320" height="250"></canvas>

				<div class="container">
					<div class="row grid_border">
						<table border="1">
							<!-- 테이블 헤더: 도시 이름 -->
							<thead>
							<tr>
								<th>새 이름</th>
								<!-- 각 도시의 이름 -->
								<th th:each="birdDosi : ${birdList}" th:text="${birdDosi.key}"></th>
							</tr>
							</thead>
							<!-- 테이블 바디: 개체수 -->
							<tbody>
							<!-- 각 새의 이름에 대해 -->
							<tr th:each="birdEntry : ${birdPage.content}">
								<td th:text="${birdEntry.key}"></td>
								<!-- 각 새의 이름에 해당하는 도시별 개체수 -->
								<td th:each="birdDosi : ${birdList}">
									<!-- 해당 도시가 존재하는지 확인 -->
									<span th:if="${birdEntry.value.containsKey(birdDosi.key)}"
										  th:text="${birdEntry.value.get(birdDosi.key)}" class="bird_value"></span>
									<!-- 해당 도시가 존재하지 않으면 0 표시 -->
									<span th:unless="${birdEntry.value.containsKey(birdDosi.key)}">-</span>
								</td>
							</tr>
							</tbody>
						</table>
						<!-- 페이지 번호 표시 -->
						<div th:if="${birdPage.getTotalPages() > 1}" style="margin: 20px 0 0 0;">
							<ul class="pagination justify-content-center">
								<!-- 처음으로 버튼 -->
								<li th:class="${birdPage.first ? 'disabled' : ''}" th:unless="${birdPage.first}">
									<a class="btn btn-primary btn-sm" th:href="@{'/?page=1'}">처음으로</a>
								</li>
								<!-- 이전 버튼 -->
								<li th:class="${birdPage.hasPrevious() ? '' : 'disabled'}" th:unless="${birdPage.first}">
									<a class="btn btn-primary btn-sm" th:href="@{'/?page=' + ${birdPage.number}}">이전</a>
								</li>
								<!-- 페이지 번호 -->
								<li th:each="i : ${#numbers.sequence((birdPage.number / 10) * 10, (birdPage.number / 10) * 10 + 9)}" th:class="${birdPage.number == i ? 'active' : ''}">
									<a class="btn btn-primary btn-sm" th:href="@{'/?page=' + ${i+1}}" onclick="updateBirdChart(/*[[${birdCount}]]*/);">[[${i+1}]]</a>
								</li>
								<!-- 다음 버튼 -->
								<li th:class ="${birdPage.hasNext() ? '' : 'disabled'}">
									<a class="btn btn-primary btn-sm" th:if="${birdPage.hasNext()}" th:href="@{'/?page=' + ${birdPage.number +2}}">다음</a>
								</li>
								<!-- 끝 버튼 -->
								<li th:class="${birdPage.last ? 'disabled' : ''}" th:unless="${birdPage.last}">
									<a class="btn btn-primary btn-sm" th:href="@{'/?page=' + ${birdPage.getTotalPages()}}">끝</a>
								</li>

							</ul>
						</div>
					</div>
					<!-- End Product Section -->

					<!-- 게시판 세션 -->
					<!-- Start Why Choose Us Section -->
					<div class="why-choose-section">
						<div class="container">
							<div class="row justify-content-between">
								<div class="col-lg-6">
									<h2 class="section-title">커뮤니티 게시판</h2>
									<p>자신이 알고 있는 지식을 사람들에게 공유해 보세요</p>

									<div class="row my-5">

										<div class="col-10 col-md-8">
											<div class="feature">
												<table>
													<tr>
														<th>번호</th>
														<th>제목</th>
														<th>내용</th>
														<th>작성일자</th>
														<th>조회수</th>
													</tr>
													<tr th:each="board : ${boardList}" th:limit="5">
														<td th:text="${board.id}"></td>
														<td><a th:href="@{|/board/${board.id}|}" th:text="${board.boardTitle}"></a></td>
														<td th:text="${board.adminBoardId}"></td>
														<td th:text="*{#temporals.format(board.BoardCreatedTime, 'yyyy-MM-dd')}"></td>
														<td th:text="${board.boardHits}"></td>
													</tr>
												</table>
											</div>
										</div>

									</div>
								</div>

								<div class="col-lg-5">
									<div class="img-wrap">
										<img th:src="@{images/오색딱따구리.jpg}" alt="Image" class="img-fluid">
									</div>
								</div>

							</div>
						</div>
					</div>
					<!-- End Why Choose Us Section -->

					<!-- Start We Help Section -->
					<div class="we-help-section">
						<div class="container">
							<div class="row justify-content-between">
								<div class="col-lg-5 ps-lg-5">
									<h2 class="section-title mb-4">과학 뉴스</h2>
									<p>새의 대한 소식을 듣고 싶다면 아래와 같이 뉴스 정보가 보입니다!</p>

									<ul class="list-unstyled custom-list my-4">
										<li th:each="science : ${scienceNews}" class="science">
											<a th:text="${science.birdysScienceonTitle}" th:href="${science.birdysScienceonSource}" style="text-decoration: none; font-size: 20px;"></a>
											<p th:text="${science.birdysScienceonContent}"></p>
										</li>
									</ul>
									<p><a herf="#" class="btn">뉴스 보러가기</a></p>
								</div>
								<div class="col-lg-5 ps-lg-5">
									<h2 class="section-title mb-4">최신 뉴스</h2>
									<p>새의 대한 소식을 듣고 싶다면 아래와 같이 뉴스 정보가 보입니다!</p>

									<ul class="list-unstyled custom-list my-4">
										<li th:each="news : ${newNews}" class="news">
											<a th:text="${news.birdysNewsTitle}" th:href="${news.birdysNewsSource}" style="text-decoration: none; font-size: 20px;"></a>
											<p th:text="${news.birdysNewsContent}"></p>
										</li>
									</ul>
									<p><a herf="#" class="btn">뉴스 보러가기</a></p>
								</div>
							</div>
						</div>
					</div>
					<!-- End We Help Section -->

					<!-- Start Blog Section -->
					<div class="blog-section">
						<div class="container">
							<div class="row mb-5">
								<div class="col-md-6">
									<h2 class="section-title">새의 앨범</h2>
								</div>
								<div class="col-md-6 text-start text-md-end">
									<a th:href="@{/}" class="more">새의 앨범 이동</a>
								</div>
							</div>

							<div class="row">


								<div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0" th:each="bird : ${birdblog}" th:id="${bird.id}">
									<div class="post-entry">
										<a href="#" class="post-thumbnail"><img th:src="${bird.birdImgUrl}" th:alt="${bird.birdName}" class="img-fluid"></a>
										<div class="post-content-entry">
											<h3 th:text="${bird.birdName}">${bird.birdName}</h3>
											<div class="meta">
												<span th:text="${bird.birdDetail}"></span>
											</div>
										</div>
									</div>
								</div>
							</div>


							</div>
						</div>
					</div>
					<!-- End Blog Section -->

				</div>
			</div>
		</div>
</html>
```
</details>

<details>
    <summary>코드 보기(Controller)</summary>

```java
@Controller
@RequiredArgsConstructor
public class MainController {
    private final BirdStatisticsService birdStatisticsService;
    private final BoardService boardService;
    private final NewsService newsService;
    private final ScienceonService scienceonService;
    private final BirdListService birdListService;


    @GetMapping("/")
    public String birdTest(Model model, HttpServletRequest request , @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "0") int scienceonPage)  {



        Pageable pageable = PageRequest.of(page -1, size);
        Page<Map.Entry<String, Map<String, Long>>> birdPage = birdStatisticsService.getBirdPage(pageable);

        // 새 총 개체수와 새 이름 목록 가져오기
        Map<String, Long> birdList = birdStatisticsService.getTotalBirdName();

        // 새 지역별 개체수 파악
        Map<String, Map<String, Long>> birdStatisticsDTOList = birdStatisticsService.getTotalCountByBirdName();

        // birdStatisticsDTOList를 라벨과 데이터로 변환
        List<String> birdLabels = new ArrayList<>(); // Map 키
        List<Long> birdData = new ArrayList<>(); // Map 값

        for (Map.Entry<String, Map<String, Long>> entry : birdPage.toSet()) {
            birdLabels.add(entry.getKey()); // 새의 이름을 라벨로 추가

            // 각 새의 지역별 개체수를 합산하여 데이터로 추가
            long totalCount = entry.getValue().values().stream().mapToLong(Long::valueOf).sum();
            birdData.add(totalCount);
        }
        // 최초 페이지 로드 여부를 확인하는 변수
        boolean isFirstPage = false;
        // 최초 페이지 로드인지 확인
        if (request.getParameter("page") == null) {
            isFirstPage = true;
        }


        // 게시판 리스트 출력
        List<BoardDTO> boardDTOList = boardService.findAll();

        // 멸종 위기종 기준
        BirdGroup group = BirdGroup.I;

        // intro 여부
        model.addAttribute("isFirstPage", isFirstPage);

        // 새의 통계 처리
        model.addAttribute("birdPage", birdPage); // 페이징 처리
        model.addAttribute("birdList", birdList); // 새의 총 개체수
        model.addAttribute("birdStatisticsDTOList", birdStatisticsDTOList); // 새 지역별 개체수
        model.addAttribute("birdLabels",birdLabels); // 새의 이름
        model.addAttribute("birdData",birdData); // 새의 지역별 개체수

        // 게시판 처리
        model.addAttribute("boardList",boardDTOList); // 게시판

        // 최신 뉴스 페이징 처리
        Page<NewsDTO> latestNews = newsService.findLatestNews(page, 4); // 최신 뉴스 4개까지 가져옴
        model.addAttribute("newNews", latestNews);

        // 과학뉴스
        Page<ScienceDTO> scienceNews = scienceonService.findScienceNews(scienceonPage, 4);// 과학 뉴스 4개까지 가져옴
        model.addAttribute("scienceNews", scienceNews);


        // 새의 앨범
        Page<BirdListFormDTO> birdblog = birdListService.getBirdListByBirdGroup(group, page, 3);
        model.addAttribute("birdblog", birdblog);
        return "index";
    }
}

```
</details>

<details>
    <summary>코드 보기(Service)</summary>

```java
@Service
@RequiredArgsConstructor
public class BirdStatisticsService {

    private final BirdStatisticsRepository birdStatisticsRepository;

    // 새의 총 개체수와 각 도시별 개체 수를 반환하는 메서드
    public Map<String, Map<String, Long>> getTotalCountByBirdName() {

        // 저장할 Map
        Map<String, Map<String, Long>> birdNameCity = new HashMap<>();
        // DB에 저장된 새의 모든 이름을 갖고옴
        List<String> birdNames = birdStatisticsRepository.findAllBirdNames();

        // 각 새 이름에 대한 개체 수를 계산하여 Map에 저장
        for (String birdName : birdNames) {
            // 각 새 이름에 대한 도시별 총 개체 수를 저장할 cityMap를 생성
            Map<String, Long> cityMap = new HashMap<>();

            // 새 이름에 대한 각 도시별 개체 수를 조회한 후 cityCounts에 저장
            List<BirdStatisticsDTO> cityCounts = birdStatisticsRepository.findCityCountsByNames(birdName);

            // 리스트 형태인 cityCounts를 1개씩 꺼내와서 cityMap에 저장
            for(BirdStatisticsDTO birdStatisticsDTO : cityCounts){
                cityMap.put(birdStatisticsDTO.getDosi(), birdStatisticsDTO.getCount());
            }
            // 새 이름과 새 이름에 대한 도시별 총 개체 수를 birdNameCity에 저장
            birdNameCity.put(birdName, cityMap);
        }
        // 담겨진 변수를 반환
        return birdNameCity;
    }

    // 새의 총 개체 수를 페이지별로 반환하는 메서드
    public Map<String, Long> getTotalCountBirdName(int page, int size) {
        Map<String, Long> totalCountByBirdName = new HashMap<>();


        // 모든 새 종류 조회, 페이징 처리
        List<String> birdNames = birdStatisticsRepository.findAllBirdNames(PageRequest.of(page,size));

        // 각 새 종류별 개체수 합산
        for (String birdName : birdNames) {
            // birdNames와 일치하는 새 이름으로 총 개체 수를 구함
            Long totalCount = birdStatisticsRepository.findTotalCountByName(birdName);

            // 새 이름과 총 개체수를
            totalCountByBirdName.put(birdName, totalCount);
        }
        // 담겨진 Map를 반환
        return totalCountByBirdName;
    }

    // 새의 도시별 개체 수를 반화하는 메서드
    public Map<String, Long> getTotalBirdName() {

        // 저장할 Map
        Map<String, Long> birdBirdNameCity = new HashMap<>();

        // DB에 저장된 새의 모든 이름을 갖고옴
        List<String> birdNames = birdStatisticsRepository.findAllBirdNames();

        // 각 새 이름에 대한 도시별 개체 수를 계산하기 위함
        for (String birdName : birdNames) {
            // 새 이름에 대한 각 도시별 개체 수를 조회하여 리스트에 저장
            List<BirdStatisticsDTO> cityCounts = birdStatisticsRepository.findCityCountsByNames(birdName);

            for(BirdStatisticsDTO birdStatisticsDTO : cityCounts){
                birdBirdNameCity.put(birdStatisticsDTO.getDosi(), birdStatisticsDTO.getCount());
            }

        }
        return birdBirdNameCity;
    }


    // 페이징 처리된 새의 통계 데이터를 반환하는 메서드
    public Page<Map.Entry<String, Map<String, Long>>> getBirdPage(Pageable pageable){

        // 새의 총 개체 수와 각 도시별 개체 수를 가져옴
        Map<String, Map<String, Long>> birdNameCity = getTotalCountByBirdName();

        // Map을 List로 변환하여 페이지 처리
        List<Map.Entry<String, Map<String, Long>>> birdStatisticsDTOList  = new ArrayList<>(birdNameCity.entrySet());

        // 페이지 번호와 페이지 크기에 따라 해당 페이지에 대한 데이터를 추출
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), birdStatisticsDTOList.size());

        List<Map.Entry<String, Map<String, Long>>> sublist = birdStatisticsDTOList.subList(start, end);


        return new PageImpl<>(sublist, pageable, birdNameCity.size());
    }

}

```
</details>

## 새의 앨범
우리나라에서 볼수 있는 조류 정보를 갖고 "**ㄱ,ㄴ,ㄷ 모음에 따른 데이터 분류**" 하여 <br>
새의 사진과 이름 새의 대한 간략한 설명글으로 구성하여 구현

<details>
    <summary>코드 보기(HTMl)</summary>

```html
<!doctype html>
<html lang="ko" xmlns:th="https://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate='~{layouts/layout1}'>

<meta name="_csrf" th:content="${_csrf.token}"/>
<head>
    <title>새의 종류</title>
</head>

<!-- body -->
<div layout:fragment="content">

    <div>
        <form th:action="@{/bird/birds}" method="get">
            <button type="submit" name="groupValue" value="GA">ㄱ</button>
            <button type="submit" name="groupValue" value="NA">ㄴ</button>
            <button type="submit" name="groupValue" value="DA">ㄷ</button>
            <button type="submit" name="groupValue" value="MA">ㄹ</button>
            <button type="submit" name="groupValue" value="BA">ㅂ</button>
            <button type="submit" name="groupValue" value="SA">ㅅ</button>
            <button type="submit" name="groupValue" value="AA">ㅇ</button>
            <button type="submit" name="groupValue" value="JA">ㅈ</button>
            <button type="submit" name="groupValue" value="CHA">ㅊ</button>
            <button type="submit" name="groupValue" value="KA">ㅋ</button>
            <button type="submit" name="groupValue" value="TA">ㅌ</button>
            <button type="submit" name="groupValue" value="PA">ㅍ</button>
            <button type="submit" name="groupValue" value="HA">ㅎ</button>
            <button type="submit" name="groupValue" value="I">I급</button>
            <button type="submit" name="groupValue" value="II">II급</button>
        </form>
    </div>

    <h1 th:text="${birdList != null and not #lists.isEmpty(birdList) ? birdList[0].birdGroup : 'Unknown'}">Bird Group</h1>

    <div class="wrap">
        <div th:each="bird : ${birdList}" th:id="${bird.id}" class="container">
            <img class="pic_bird" th:src="${bird.birdImgUrl}" th:alt="${bird.birdName}">
            <h3 th:text="${bird.birdName}">${bird.birdName}</h3>
            <p th:text="${bird.birdDetail}"></p>
        </div>
    </div>

</div>

</html>

```
</details>

<details>
    <summary>코드 보기(Controller)</summary>

```java
@Controller
@RequestMapping("/bird")
@RequiredArgsConstructor
public class BirdListController {

    @Autowired
    private BirdListService birdListService;
    private final BirdService birdService;
    private final BirdStatisticsService birdStatisticsService;

    @GetMapping("/birds")
    public String getBird(Model model, @RequestParam(required = false) String groupValue) {

        // 기본 group 값을 ga로 설정.
        BirdGroup group = BirdGroup.GA;

        // 하나의 페이지를 사용해 여러 리스트를 보여주기 위해서 switch문을 사용해 리스트를 구분할 group값 변경하기.
        // (= 버튼에 value = "group" 값 지정.)
        if(groupValue != null){
            switch(groupValue){
                case "NA" : group = BirdGroup.NA;
                    break;
                case "DA" : group = BirdGroup.DA;
                    break;
                case "MA" : group = BirdGroup.MA;
                    break;
                case "BA" : group = BirdGroup.BA;
                    break;
                case "SA" : group = BirdGroup.SA;
                    break;
                case "AA" : group = BirdGroup.AA;
                    break;
                case "JA" : group = BirdGroup.JA;
                    break;
                case "CHA" : group = BirdGroup.CHA;
                    break;
                case "KA" : group = BirdGroup.KA;
                    break;
                case "TA" : group = BirdGroup.TA;
                    break;
                case "PA" : group = BirdGroup.PA;
                    break;
                case "HA" : group = BirdGroup.HA;
                    break;
                    //멸종위기종
                case "I" : group = BirdGroup.I;
                    break;
                case "II" : group = BirdGroup.II;
                    break;
                    //따로 지정 값이 없다면(큰 카테고리명을 클릭했을 경우) 기본 ga 값으로 지정되어 'ㄱ'리스트 보여짐.
                default: group = BirdGroup.GA;
                    break;
            }
        }

        List<BirdList> birdList = birdListService.getBirdListByBirdGroup2(group);
        model.addAttribute("birdList", birdList);
        return "bird/birdListForm";
        //사용자가 선택한 group 값을 가지고 해당 페이지로 이동
    }

    @GetMapping("/birdy")
    // 새의 탐조
    public String showBirds(@RequestParam(required = false) String type, Model model) {
        List<Birds> birds = birdService.showBirds(type);
        model.addAttribute("birds", birds);
        return "bird/birdybird";
    }

}

```
</details>

<details>
    <summary>코드 보기(Service)</summary>

```java
@Service
public class BirdListService {

    @Autowired
    private BirdRepository birdRepository;

    public List<BirdList> getBirdListByBirdGroup2(BirdGroup group) {
        return birdRepository.findByBirdGroup(group);
    }

    public Page<BirdListFormDTO> getBirdListByBirdGroup(BirdGroup group, int page, int size) {


        return birdRepository.findByBirdGroup(group,PageRequest.of(page,size)).map(this::birdListFormDTO);
    }

    public BirdListFormDTO birdListFormDTO(BirdList birdList){

        BirdListFormDTO birdListFormDTO = new BirdListFormDTO();

        birdListFormDTO.setId(birdList.getId());
        birdListFormDTO.setBirdName(birdList.getBirdName());
        birdListFormDTO.setBirdDetail(birdList.getBirdDetail());
        birdListFormDTO.setBirdImgUrl(birdList.getBirdImgUrl());
        birdListFormDTO.setGroup(birdList.getBirdGroup());
        return birdListFormDTO;
    }


    //크롤링으로 데이터 긁어오기
    private static final int PTAGE_LIMIT = 3;

    @Autowired
    public void BirdListService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @PostConstruct
    @Transactional
    public void SaveBird() {
    }
}
```
</details>




# 시연 연상 및 팀원 후기
팀프로젝트를 하면서 팀원들의 느낀 부분입니다

## 시연 연상
<img src="https://github.com/koyuhjkl123/Project_Bridy/assets/94844952/93f5c1bf-0f64-46d2-8146-07be08ededde" width="40" height="40"/>   : [시연 연상](https://youtu.be/Hf6y94OGwWw)


## 김진수(팀장)
처음에는 DB 설계와 요구사항 명세서 작성, 기능 설계로 시작했으며, 이 단계에서 많은 시간이 소요되었습니다. <br>
처음이라 여러 번의 수정을 거쳤고, 다양한 참고 자료를 통해 많은 시행착오를 겪으며 진행했습니다.
<br>
새 통계 구현 시 복잡성 때문에 예상보다 일정이 오래 걸렸습니다. <br>
**특히, 타임리프를 사용한 2중 맵 데이터 가공 작업이 도전적**이었습니다. <br>
키-값 구조를 사용하여 데이터를 추출하는 작업이 처음이었지만, 가독성이 좋았습니다. <br>
메인 페이지에 추가 데이터를 표시하기 위해 추가 데이터 가공 작업도 수행했습니다. <br>
<br>
이 프로젝트를 통해 요구사항 명세서와 기능 설계, 그리고 팀원 간의 소통과 협업의 중요성을 배웠습니다. <br>
초기 설계와 명세서 작성이 어려웠지만, 지속적인 의사소통을 통해 문제를 해결하고 중복성을 최소화하는 방법을 고민하게 되었습니다.
<br>
향후 프로젝트에서는 초기 단계에서 더 많은 시간을 할애하고, 기술적인 학습을 통해 더 나은 결과를 얻을 수 있을 것이라고 생각합니다.
## 이세진(팀원)
데이터를 크롤링해오고, 이메일 인증을 받아오는 기능을 구현하는 데에 많은 시행착오를 거치며 <br>
힘들기도 했지만, 새로운 도전을 한 것과 그 것을 성공했을 때의 성취감이 매우 컸습니다. <br>
웹 사이트를 구현하는 데에 얼마나 많은 시간과 고뇌가 필요한지 확실히 깨달을 수 있는 경험이었고, <br>
그럼에도 기능을 하나하나 완성해 갈 때마다 성취감이 커, 돌아보면 즐거운 시간이었습니다. <br>
다만, 미숙했던 시간분배와 계획, 부족한 시간으로 인해 미처 다 구현해내지 못 한 기능들이 있어 <br>
아쉽습니다. 이후 부족하거나, 제대로 기능되지 못 한 부분들을 보완하여 저희 팀의 결과물을 완성하고 싶습니다.
<br>
## 김기윤(팀원)
이전 프로젝트에서 Rest방식의 기초를 학습하여, 이번 프로젝트에서 보다 깔끔한 코드를 만들 수 있었던거 같습니다. <br>
검색기능에서 Rest방식을 써보고 싶었지만, 데이터를 받아서 동시에 페이지 처리는 하지 못하여, 아쉬웠습니다. <br> 
다음에는 검색기능부분을 보완하여, 보다 완성도 높은 RestFul 방식의 홈페이지를 만들고 싶습니다. <br>

