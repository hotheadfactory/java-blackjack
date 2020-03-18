## 블랙잭 기능 목록 

- [x] 게임 참여자의 이름 입력  
    - [x] 쉼표를 기준으로 분리
    - [x] **예외** 
        - [x] 중복된 이름이 있을 경우
        - [x] 이름을 한 명도 입력하지 않을 경우  
        - [x] 참가자가 8명을 초과할 경우
- [ ] 플레이어별로 배팅 금액 입력
    - [ ] **예외**
        - [ ] 숫자가 아닌 경우
        - [ ] 양수가 아닌 경우
- [x] 딜러/선수들에게 카드 분배  
    - [x] 랜덤으로 카드를 섞어서 분배  
    - [x] 분배 결과 출력  
        - [x] 딜러는 카드를 한 장만 표시
        - [x] 선수들은 모든 카드 표시  
- [x] 선수들에게 카드를 추가적으로 한 장 더 뽑을 것인지 선택하게 함 
    - [x] Y를 누르면 한 장을 더 뽑고 수중의 카드를 보여줌  
    - [x] N을 누르면 중지하고 다음 선수에게 넘어감
    - [x] bust 되어도 중지하고 다음 선수에게 넘어감
    - [x] **예외**
        - [x] Y, N이 아닌 다른 문자를 입력한 경우
- [x] A는 1 또는 11로 계산할 수 있음
    - [x] A를 1로 환산한 총합이 11 이하일 때 10을 더해줌 (자동 계산)
- [x] 딜러가 분배받은 2장의 카드 합이 16 이하일 때 카드를 자동으로 한 장 더 뽑음
- [x] 딜러와 모든 선수의 수중의 카드를 공개하고 결과를 발표
    - [x] 각각의 카드와 점수를 출력
    - [ ] 최종 수익 출력
    

| 조건                                     | 플레이어의 승패 여부| 수익률 |
| ---------------------------------------- | --------------|------ |
| 플레이어가 딜러보다 21에 가까운 경우     | 승  |+100%                 |
| 플레이어가 블랙잭이고 딜러가 아닌 경우   | 승  |+150%                 |
| 플레이어가 살아남고 딜러가 버스트인 경우 | 승  |+100%                 |
| 딜러가 플레이어보다 21에 가까운 경우     | 패  |-100%                 |
| 딜러가 블랙잭이고 플레이어는 아닌 경우   | 패  |-100%                 |
| 딜러가 살아남고 플레이어가 버스트인 경우 | 패  |-100%                 |
| 플레이어와 딜러가 같은 점수인 경우       | 무승부  |0%             |
| 플레이어와 딜러 둘 다 블랙잭인 경우      | 무승부  |0%             |
| 플레이어와 딜러 둘 다 버스트인 경우      | 무승부  |0%             |