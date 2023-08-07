<div align="center">
  <br>
  <img width="273" alt="image" src="https://github.com/FAST-Mini-Project/back-end/assets/70641477/369534fb-bd9c-48ca-90a4-23ca24864e9f">
  <br>
  <h1>당연해 (당직 & 연차 관리 프로그램) <a href="https://dangyeonhae.netlify.app">🔗</a></h1>
  <br>
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

[`🔗 Front-End Repository 이동하기`](https://github.com/FAST-Mini-Project/front-end)

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
<img width="815" alt="image" src="https://github.com/khsrla9806/practice-readme/assets/70641477/26e98d00-3c68-494c-93dc-f78511f94319">

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
