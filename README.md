# Assignment3

### **[필수 포함 사항]**

- [READ.ME](http://read.me/) 작성
    - 프로젝트 빌드, 자세한 실행 방법 명시
    - 구현 방법과 이유에 대한 간략한 설명
    - 완료된 시스템이 배포된 서버의 주소
    - 해당 과제를 진행하면서 회고 내용 블로그 포스팅
- Swagger나 Postman을 이용하여 API 테스트 가능하도록 구현

### **확인 사항**

- **ORM 사용 필수**
- **데이터베이스는 SQLite로 구현**
- **secret key, api key 등을 레포지토리에 올리지 않도록 유의**
    - README.md 에 관련 설명 명시 필요

### **도전 과제: 스스로에게도 도움이 되는 내용 + 추가 가산점**

- 배포하여 웹에서 사용 할 수 있도록 제공
- 임상정보 검색 API 제공

### **과제 안내**

다음 사항들을 충족하는 서비스를 구현해주세요.

- 임상정보를 수집하는 batch task
    - 참고: [https://www.data.go.kr/data/3074271/fileData.do#/API 목록/GETuddi%3Acfc19dda-6f75-4c57-86a8-bb9c8b103887](https://www.data.go.kr/data/3074271/fileData.do#/API%20%EB%AA%A9%EB%A1%9D/GETuddi%3Acfc19dda-6f75-4c57-86a8-bb9c8b103887)
- 수집한 임상정보에 대한 API
    - 특정 임상정보 읽기(키 값은 자유)
- 수집한 임상정보 리스트 API
    - 최근 일주일내에 업데이트(변경사항이 있는) 된 임상정보 리스트
        - pagination 기능
- **Test 구현시 가산점이 있습니다.**