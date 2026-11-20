# spring-shopping-precourse

## 기능 요구 사항
- 온라인 쇼핑몰을 위한 간단한 HTTP API를 구현
- HTTP 요청과 응답은 JSON 형식으로 주고 받음
- 스프링 프레임워크를 사용하여 웹 애플리케이션으로 구현

## 구현 전략

### 계층 구조
- Controller → Service → Repository
    - Controller: 요청/응답 처리만
    - Service: 비즈니스 로직 조합 (비속어 검사 등 외부 API 호출 포함)
    - Repository: 데이터 저장/조회만
- 도메인 객체에서 자체 유효성 검증 (이름 길이, 특수 문자)

### 데이터 저장
- DB 없이 `HashMap`을 활용한 인메모리 저장

### 인증
- JWT 없이 간단한 토큰 방식 사용
- 로그인 시 `UUID` 토큰을 발급하고 인메모리로 관리
- 요청 시 `Authorization` 헤더에 토큰을 포함하여 인증

### 비속어 검사
- `PurgoMalumClient`에서 `https://www.purgomalum.com/service/containsprofanity` 엔드포인트를 호출하여 비속어 포함 여부 확인

## 구현할 기능 목록
### 상품
- [ ] 상품
    - [x] 이름, 가격, 이미지 URL이 포함
    - [x] 상품 이미지는 파일 업로드가 아닌 URL 입력 방식으로 관리
    - [x] 상품 이름은 공백을 포함하여 최대 15자까지 입력 가능
    - [x] 상품 이름에 허용된 특수 문자만 사용할 수 있다.
        - 허용: `( ) [ ] + - & / _`
    - [x] 상품 이름에는 비속어 포함 불가
        - [x] PurgoMalum API 호출하여 비속어 포함 여부 검사
- [x] 상품 생성 (`POST /api/products`)
    - 이름, 가격, 이미지 URL을 입력받아 새 상품을 등록한다.
- [x] 상품 조회 (`GET /api/products/{productId}`)
    - 특정 상품의 정보를 조회한다.
- [ ] 상품 목록 조회 (`GET /api/products`)
    - 모든 상품의 목록을 조회한다.
- [ ] 상품 수정 (`PUT /api/products/{productId}`)
    - 기존 상품의 정보를 수정한다.
- [ ] 상품 삭제 (`DELETE /api/products/{productId}`)
    - 특정 상품을 삭제한다.

### 회원 로그인
- [ ] 회원 가입 (`POST /api/members/register`)
    - 이메일과 비밀번호로 회원을 등록하고 토큰을 발급
- [ ] 로그인 (`POST /api/members/login`)
    - 이메일과 비밀번호를 검증하고, 일치하면 인증 토큰을 발급

### 위시 리스트

- [ ] 위시 리스트 상품 추가 (`POST /api/wishes`)
    - 인증된 회원의 위시 리스트에 상품을 추가한다.
- [ ] 위시 리스트 상품 조회 (`GET /api/wishes`)
    - 인증된 회원의 위시 리스트에 있는 상품을 조회한다.
- [ ] 위시 리스트 상품 삭제 (`DELETE /api/wishes/{wishId}`)
    - 인증된 회원의 위시 리스트에서 상품을 삭제한다.
