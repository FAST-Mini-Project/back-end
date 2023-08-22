<div align="center">
  <br>
  <img width="273" alt="image" src="https://github.com/FAST-Mini-Project/back-end/assets/70641477/369534fb-bd9c-48ca-90a4-23ca24864e9f">
  <br>
  <h1>당연해 (당직 & 연차 관리 프로그램) <a href="https://dangyeonhae.netlify.app">🔗</a></h1>
  <br>
  
  [**`🔗 Front-End 저장소로 이동하기 👈🏻`**](https://github.com/FAST-Mini-Project/front-end)
  <br><br>
  [**`🔗 배포된 링크로 이동하기 👈🏻`**](https://dangyeonhae.netlify.app)
  <br><br>
  [**`🔗 발표자료 보러가기 👈🏻`**](https://drive.google.com/file/d/1xF5DoUv80Z8CPMxuL_F2O6O0yBcOYOXr/view?usp=sharing)
</div>

<br>

## 🗓️ 프로젝트 기간
`2023-07-24 ~ 2023-08-11`

<br><br>

## 🙌🏻 프로젝트 설명
- 파이널 프로젝트 시작 전 프론트엔드와 원활한 협업 연습을 위한 미니 프로젝트입니다.
- REST API를 설계, 개발하여 직접 서버를 배포하고 프론트엔드와 통신하는 방법을 학습합니다.

<br><br>

## 👨‍👨‍👦‍👦 개발 팀원
| Back-End 👑 | Back-End | Back-End | Front-End 👑 | Front-End | Front-End |
| :-----------------: | :--------: | :--------: | :-------: | :-------: | :-------: |
| <img src="https://avatars.githubusercontent.com/u/70641477?v=4" width="150"> |<img src="https://avatars.githubusercontent.com/u/72866347?s=96&v=4" width="150">  | <img src="https://avatars.githubusercontent.com/u/104764933?s=96&v=4" width="150"> | <img src="https://avatars.githubusercontent.com/u/84277185?s=96&v=4" width="150"> | <img src="https://avatars.githubusercontent.com/u/125433485?v=4" width="150">  | <img src="https://avatars.githubusercontent.com/u/128157440?s=96&v=4" width="150">  |
| [김훈섭](https://github.com/khsrla9806)            | [김경호](https://github.com/KimGyeongHo-com)   | [강경민](https://github.com/redbean00)   | [김경원](https://github.com/ruddnjs3769)  | [윤금엽](https://github.com/DevYBecca)  | [황인승](https://github.com/hwanginseung)  |

<br><br>

## 💡 주요 기능
- **`사용자(사원)`**
  - 회원 가입
    - 이메일, 비밀번호, 이름 입력 후 가입 (사원 번호는 자동으로 할당)
  - 원하는 날짜에 연차 신청
  - 연차 취소 & 취소 신청
  - 마이페이지 기능
    - 잔여 연차 조회, 자신이 사용한 모든 연차 정보 조회
    - 할당받은 당직 조회
    - 비밀번호 재설정
  - 메인페이지 기능
    - 모든 사원의 연차, 당직 현황 조회
   
- **`관리자`**
  - 신청된 연차의 승인, 반려 결정
  - 취소 신청된 연차의 승인, 반려 결정
  - 당직 등록, 삭제
  - 모든 사원 정보 조회
    - 잔여 연차수 조회
    - 할당된 당직수 조회

<br><br>

## 🧑🏻‍💻 팀원 역할
| 이름 | 역할 |
| :-----------------: | -------------------------------- |
| 김훈섭<br>`팀장`            | - **관리자 페이지 기능 구현**<br>&nbsp;&nbsp;└ 사용자 전체 목록 조회 (잔여 연차수, 당직수 통계)<br>&nbsp;&nbsp;└ 사원 계정 삭제 (관련 데이터 모두 삭제)<br>&nbsp;&nbsp;└ 당직 등록, 삭제<br>&nbsp;&nbsp;└ 모든 연차 조회 (신청 대기, 취소 상태)<br>&nbsp;&nbsp;└ 연차 승인, 반려<br>- DB 설계<br>- API 설계<br>- 서버 배포   |
| 김경호            | - **스프링 시큐리티**를 이용한 로그인, 회원가입 기능 구현<br>- **JWT 토큰** 기능 구현<br>- AWS LightSail 서버 세팅<br>- 회원 비밀번호 수정<br>- DB 설계<br>- API 설계<br>- 서버 배포   |
| 강경민            | - **마이페이지, 메인페이지 기능 구현**<br>&nbsp;&nbsp;└ 개인 연차, 당직 조회<br>&nbsp;&nbsp;└ 연차 신청, 연차 취소 신청 (JWT 토큰 사용)<br>&nbsp;&nbsp;└ 연차, 당직 전체 목록 조회<br>- DB 설계<br>- API 설계<br>- 서버 배포   |

<br><br>

## 🛠️ 프로젝트 기술스택
- **`Back-End`**<br><br>
  <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=springsecurity&logoColor=white">
  <img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat-square&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/Java 11-FF160B?style=flat-square&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/Amazon AWS-41454A?style=flat-square&logo=amazonaws&logoColor=white">
<br>

- **`Front-End`**<br><br>
  <img src="https://img.shields.io/badge/React-61DAFB?style=flat&logo=React&logoColor=white">
  <img src="https://img.shields.io/badge/TypeScript-3178C6?style=flat&logo=TypeScript&logoColor=white">
  <img src="https://img.shields.io/badge/Sass-CC6699?style=flat&logo=Sass&logoColor=white">
  <img src="https://img.shields.io/badge/Ant Design-0170FE?style=flat&logo=antdesign&logoColor=white">
  <img src="https://img.shields.io/badge/npm-CB3837?style=flat&logo=Npm&logoColor=white">
  <img src="https://img.shields.io/badge/Vite-646CFF?style=flat&logo=Vite&logoColor=white">
  <img src="https://img.shields.io/badge/Netlify-00C7B7?style=flat&logo=netlify&logoColor=white">
<br>

- **`Collaboration Tool`**<br><br>
  <img src="https://img.shields.io/badge/Git-F05032?style=flat&logo=Git&logoColor=white">
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white">
  <img src="https://img.shields.io/badge/Figma-F24E1E?style=flat&logo=figma&logoColor=white">
  <img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=Slack&logoColor=white">
  <img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=Notion&logoColor=white">
  <img src="https://img.shields.io/badge/Zoom-2D8CFF?style=flat&logo=Zoom&logoColor=white">

<br><br>

## 📁 백엔드 패키지 구조
```markdown
com
|-- 📂mini
|   |-- 📂annualwork
|   |   |-- 📂component
|   |   |-- 📂config
|   |   |-- 📂controller
|   |   |-- 📂core
|   |   |-- 📂dto
|   |   |-- 📂entity
|   |   |   └-- 📂type
|   |   |-- 📂exception
|   |   |   └-- 📂handler
|   |   |-- 📂repository
|   |   |-- 📂service
└---└---└-- 📂utils
```

<br><br>

## 📖 API 명세
<img width="815" alt="image" src="https://github.com/FAST-Mini-Project/back-end/assets/70641477/255d45af-d72a-4f1b-a52d-2b230a3f74cd">

<br><br>

## 🖥️ 프로젝트 실행 방법
- 프로젝트 파일 클론
```bash
>> git clone git@github.com:FAST-Mini-Project/back-end.git
```

<br>

- application.yml 설정
```yaml
spring:
  datasource:
    url: jdbc:mysql://[IP]:[Port]/[데이터베이스 스키마]
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: [데이터베이스 유저네임]
    password: [데이터베이스 비밀번호]

  jpa:
    show-sql: true
    hibernate:
      ddl-auto: [ddl-auto 설정 (create, create-drop, none)]
    properties:
      hibernate:
        format_sql: true

# JWT 설정
jwt:
  secret: [JWT 토큰 발행에 필요한 시크릿키]

```

<br>

- 프로젝트 빌드
```bash
>> ./gradlew clean build
```

<br>

- jar 파일 실행
```bash
>> java -jar ./build/libs/anuualwork-0.0.1-SNAPSHOT.jar
```

<br><br>

## ► 프로젝트 시현
![당연해](https://github.com/FAST-Mini-Project/back-end/assets/70641477/6192154f-04a9-4e24-a815-31b52ff0773d)



<br><br>

## 🙋🏻‍♂️ 협업 방식
- Back-End Repository 생성 후 프로젝트 초기 세팅 진행
- main, develop 브랜치 생성
- 각자 Local Repository로 Fork 저장소 생성
- 작업 시작
  - 이슈 생성 (이슈 번호 할당 `#12`)
  - 이슈 번호에 해당하는 브랜치 생성 (ex. `feature/#12-admin-crud`)
  - 브랜치에서 코드 작업 진행
  - 작업 완료 후 commit message 작성 (ex. `[#12] feat: 관리자 연차 등록 구현`)
  - Local Fork 저장소에 Push
  - Main 저장소의 develop 브랜치로 Pull Request 요청
  - Rebase And Merge 전략으로 병합 (충돌은 최대한 Local에서 해결, 깔끔한 커밋 메시지 관리를 위함)
  - 프로젝트 종료 후 develop에서 main으로 Pull Request 요청 후 병합
- 개발 서버 배포 기간을 협의 후 해당 날짜에 맞춰서 진행
- 서버 배포 직전에는 반드시 프론트엔드에게 통보

<br><br>

## ✋🏻 깃허브 커밋 메시지 규칙
```
[#이슈번호] feat: 새로운 기능 추가했을 때
[#이슈번호] fix: 버그나 오류 수정했을 때
[#이슈번호] refactor: 코드 리팩토링했을 때
[#이슈번호] chore: 약간 애매한 기타 변경사항
[#이슈번호] docs: 리드미 파일이나 md 파일 수정할 때 (문서작업)
```

<br><br>

## 🙋🏻‍♂️ 코드리뷰 요청
`강경민`
> @Query에 작성한 쿼리 위주로 코드리뷰 받고 싶습니다. 🙆🏻‍♂️
- [개인 연차 취소 및 취소 신청 기능 구현](https://github.com/redbean00/back-end/commit/525554a356205b7c675a6e7cbf377cc00e73768f)
- [개인 당직 조회 기능 구현](https://github.com/redbean00/back-end/commit/03cebf370d358f2947f47ed1de58cd304a90f10b)
- [개인 연차 조회 기능 구현](https://github.com/redbean00/back-end/commit/4d9a76bab74f42152b8896eadbe56656bc4e3828)
- [연차 당직 조회 기능 구현](https://github.com/redbean00/back-end/commit/0f834e7083373b6f4848731ad8078d245e1bf436)

`김훈섭`
> Validation을 사용하는 모든 Controller에서 공통적으로 사용되는 코드라고 생각돼서 Utils 클래스로 분리를 해두었는데, 반복적이라도 그냥 각 Controller에서 각자 작성하는게 나았을지 궁금합니다. AOP로 해볼까 하다가 시간이 부족해서 그냥 넘겼던 부분인데, 궁금함이 남아서 리뷰 부탁 드립니다 🙆🏻‍♂️
- [bindingResult 결과를 받아서 유효성 검사를 진행하는 ValidationUtils 추가](https://github.com/FAST-Mini-Project/back-end/commit/d2d685fc7fbc5270d959f78d99a9e36b4272cf22)
- [ValidationUtils 사용하는 부분](https://github.com/FAST-Mini-Project/back-end/commit/e5b0d3cf485b1f28168aaf974299ff2a96d772e9)

> @Query를 사용해서 쿼리 결과를 Projection할 때, JPQL 안에서 new 연산자를 통해서 DTO를 생성하거나, 인터페이스 구현(interface + getter)을 통해서 받아오는 방법이 있다고 해서, 제가 느끼기에는 interface + getter를 사용해서 결과를 받아오는 것이 가독성이 좋아보여서 이렇게 처리했는데, 혹시 현업에서 이런 경우가 있다면 어떤 방법을 이용해서 Projection 결과를 DTO에 담게 되나요? QueryDSL을 쓰면 좀더 깔끔하게 사용할 수 있다고 하는데, 해당 내용을 학습하기 이전이어서 리뷰 부탁드립니다! 🙆🏻‍♂️
- [AdminDto 생성 후 JPQL Projection 결과를 담을 interface 구현](https://github.com/FAST-Mini-Project/back-end/commit/7d657a74e2a57553589e4a7794beffea230c261e)
- [AdminMemberRepository 생성 후 JPQL을 사용하여 쿼리 메서드 구현](https://github.com/FAST-Mini-Project/back-end/commit/9efcc6825c506c0d73ae55483444c3cfedb27fa5)
