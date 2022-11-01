# MobileProgramming Assignment README.md

## 

 - compileSdk : 31
 - AVD (Pixel 2 API 31) 및 실제 안드로이드 기기 (Galaxy S21+) 사용



## 1. 첫번째 화면

<img src = "https://user-images.githubusercontent.com/88530565/199211826-e4be5514-34e8-4b65-8f91-4882846e873c.jpg"  width="200" />

 - RelativeLayout 사용
 - 앱 접속 페이지
 - ID, Password : EditText / Login, 비회원으로 이용하기, 회원가입 : Button
 - [비회원으로 이용하기] 클릭 시 세번째 화면으로 바로 이동
 
</br>

### 1_1. 정보 입력
<img src = "https://user-images.githubusercontent.com/88530565/199212448-6d346d5e-b967-4d93-b917-d47f9f8109e8.jpg" width="200" />
</br>

### 1_2. 로그인 성공
<img src = "https://user-images.githubusercontent.com/88530565/199214952-95627b0d-56be-4809-8c39-14c1208fc1e6.jpg" width = "200" />

 - 입력된 정보가 이상이 없으면 로그인 성공 후 세번째 화면으로 이동
### 1_3. 비회원으로 이용하기
<img src = "https://user-images.githubusercontent.com/88530565/199217542-5bf0b5d1-308a-4e2a-9c6b-80ef5591d11c.jpg" width = "200" />

 - 세번째 페이지로 바로 이동
</br>

### 1_4. 존재하지 않는 ID 입력 or Password 오류
<div>
<img src = "https://user-images.githubusercontent.com/88530565/199212812-bebe1961-5d7a-4bd2-b370-1f6a3b7c9d67.jpg" width="200"/>
<img src = "https://user-images.githubusercontent.com/88530565/199214387-0d0cad5d-74cd-4616-8a35-7768358b0aa7.jpg" width="200"/>
</div>

 - Toast 를 통한 에러 메시지 출력

</br>

## 2. 두번째 화면
<img src = "https://user-images.githubusercontent.com/88530565/199215379-8b87ffcc-9947-4284-b576-2f359184dbe7.jpg" width = "200"/>

 - LinearLayout 사용
 - 회원가입 페이지
 - ID, Password, 전화번호, 이름, 주소 : EditText / 이용약관 동의 여부 : RadioGroup
 - [개인정보 사용동의 약관] Button 으로 이용약관 확인

### 2_1. ID 중복검사 & Password 규칙 check
<div>
<img src = "https://user-images.githubusercontent.com/88530565/199216120-4c65bd8a-e3b2-45fb-810d-ade412059aea.jpg" width = "200"/>
<img src = "https://user-images.githubusercontent.com/88530565/199216186-aa1f90ab-f315-4610-b2ca-75c2ae7e1f31.jpg" width = "200"/>
</div>

 - Toast 를 통한 에러 메시지 출력
 - 이용약관 미동의, 전화번호 입력 오류시에도 에러 메시지 출력


### 2_2. 이용약관 
<img src = "https://user-images.githubusercontent.com/88530565/199216584-bfa83076-ed30-421f-8442-0b6f690d3612.jpg" width = "200"/>

### 2_3. 회원가입 완료
<img src = "https://user-images.githubusercontent.com/88530565/199216765-ae170d51-5090-4b38-9c4c-c36a62d03b2b.jpg" width = "200"/>

 - 회원정보 저장 (SQLite) 후 첫번째 페이지로 이동

## 3. 세번째 화면

<img src = "https://user-images.githubusercontent.com/88530565/199217758-a252748b-5245-4343-bf01-5a8033f00863.jpg" width = "200"/>
                                                                                                                            
 - Constraint Layout 사용
 - 상품 출력 페이지
 - 회원정보 확인하기, 상품 추가하기, 상품 삭제하기 : Button
 - 상품 : ImageView

### 3_1. 회원정보 확인 : 회원 / 비회원
<div>
<img src = "https://user-images.githubusercontent.com/88530565/199220003-944dc032-f3e4-4916-a09c-76dd9456aaef.jpg" width = "200"/>
<img src = "https://user-images.githubusercontent.com/88530565/199220098-96644646-be85-4f87-b2b5-86f74afacd35.jpg" width = "200"/>
</div>

 - 회원 : ID, Password 출력
 - 비회원 : [동의] 선택 시 회원가입 페이지로 이동

### 3_2. 영화 선택 & 영화 삭제

<div>
 <img src = "https://user-images.githubusercontent.com/88530565/199220361-a20d6b28-0529-4d97-a88d-1b3dc119b13a.jpg" width = "200"/>
<img src = "https://user-images.githubusercontent.com/88530565/199220367-a632ba98-ccc5-41cf-bcc2-bf852e427ccc.jpg" width = "200"/>
 </div>

 - 영화 선택 시 영화 이름 출력
 - 선택 후 삭제 버튼 -> 영화 삭제
