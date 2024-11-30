# 주식 배당금 정보 조회 서비스 API

## 개발 환경
- **IDE**: IntelliJ IDEA Community
- **Java Version**: Java 17
- **Build Tool**: Gradle 7.2
- **Spring Boot**: 2.5.6

## 기술 스택
- **백엔드 프레임워크**: Spring Boot, Spring Security, Spring Data JPA
- **데이터베이스**: H2 (인메모리 DB), Redis (캐시)
- **데이터 수집**: Jsoup (웹 스크래핑)
- **인증 및 보안**: JWT (JSON Web Token)
- **라이브러리**: Lombok (코드 간소화)

## API 명세
### 1. /auth
- #### 회원가입 API
  - **HTTP Method**: `POST /signup`
  - **설명**: 새로운 사용자를 회원가입 시킵니다. 중복된 ID는 허용되지 않으며, 패스워드는 암호화된 형태로 저장됩니다.

- #### 로그인 API
  - **HTTP Method**: `POST /signin`
  - **설명**: 로그인 후 JWT를 발급합니다. 회원가입이 되어 있으며, 입력된 아이디와 패스워드가 일치할 경우에만 토큰을 발급합니다.

### 2. /company
- #### 회사명 검색 API
  - **HTTP Method**: `GET /autocomplete`
  - **설명**: 특정 prefix를 입력받아 해당 prefix로 시작하는 회사명 리스트 중 최대 10개를 반환합니다.

- #### 회사 목록 확인 API
  - **HTTP Method**: `GET /`
  - **설명**: 서비스에서 관리 중인 모든 회사 목록을 페이지네이션 형태로 반환합니다.

- #### 회사 정보 추가 API
  - **HTTP Method**: `POST /`
  - **설명**: 특정 회사의 ticker를 입력받아, 해당 회사 정보를 스크래핑하여 저장합니다. 이미 보유 중인 회사이거나 존재하지 않는 회사 ticker일 경우, 400 상태 코드와 함께 에러 메시지를 반환합니다.

- #### 회사 정보 삭제 API
  - **HTTP Method**: `DELETE /{ticker}`
  - **설명**: 해당 ticker의 회사 정보를 삭제합니다. 삭제 시 관련된 회사의 배당금 정보와 캐시도 함께 삭제됩니다.

### 3. /finance
- #### 배당금 정보 확인 API
  - **HTTP Method**: `GET /dividend/{companyName}`
  - **설명**: 특정 회사명을 입력받아, 해당 회사의 메타 정보와 배당금 정보를 반환합니다. 잘못된 회사명이 입력되면 400 상태 코드와 함께 에러 메시지를 반환합니다.
