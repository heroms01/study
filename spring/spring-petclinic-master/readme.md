## 의존성 주입
* 생성자 주입
 - 스프링 레퍼런스에서 권장
 - 생성자를 통해서 not null 클래스들을 강제 한다.
 - 상호참조 문제가 발생할 수도 있다.
 
* 필드 주입
 - 상호참조 문제를 해결할 수 있다.
 - not null 클래스들이 생성될 수도 있다.

## AOP 구현 방법
* 컴파일 (AspectJ)
Car.java --- (AOP) ---> Car.class

* 바이트 코드 조작 (AspectJ)
Car.java ---> Car.class --- (AOP) ---> 메모리

* 프록시 패턴 (스프링 AOP)
Car.java --- (AOP) ---> Car.class
