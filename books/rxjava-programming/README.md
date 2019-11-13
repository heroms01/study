# Ch1
* 기존 명령형 프로그래밍은 작성한 코드가 정해진 순서대로 실행된다(pull).
* 리액티브 프로그래밍은 데이터 흐름을 먼저 정의 하고 데이터가 변경되었을때 업데이트 된다(push).
~~~
# RxJava와 WebFlux간 비교
RxJava              WebFlux
---------------------------
Observable          Flux
 > Maybe
 > Flowable
Single              Mono
~~~
## RxJava 학습 순서
## 마블 다이어그램 보는 법

# Ch2
* Observable은 데이터 흐름에 맞게 알림을 보내 구독자가 데이터를 처리하게 한다.
* Maybe는 데이터가 발행되거나 혹은 발행되지 않고도 완료.
* Flowable은 데이터 발행속도 배압이슈에 대응.
 