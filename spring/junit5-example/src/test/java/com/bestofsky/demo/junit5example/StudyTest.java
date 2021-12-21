package com.bestofsky.demo.junit5example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StudyTest {
    @Test
    @DisplayName("스터디 NotNull")
    void test1() {
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    @DisplayName("스터디 초기 상태 Draft")
    void test2() {
        Study study = new Study();
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "초기 상태는 Draft 여야 한다.");
    }

    @Test
    @DisplayName("Assert all")
    void test3() {
        Study study = new Study();

        assertAll(
            () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "초기 상태는 Draft 여야 한다."),
            () -> assertTrue(study.getLimit() > 0, "스터디 참가인원은 1명 이상")
        );
    }

    @Test
    @DisplayName("Throw test")
    void test4() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-12));
        assertEquals("수강인원은 1명 이상이여야 한다.", exception.getMessage());
    }

    @Test
    @DisplayName("타임아웃 테스트")
    void test5() {
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study();
            Thread.sleep(10);
        });
    }

    @Test
    @DisplayName("시스템 환경설정에 따라 테스트 진행")
    void test6() {
        String env = System.getenv("THEME");

        // 여기서 false 되면 이후 진행 불가
        assumeTrue("Dark".equalsIgnoreCase(env));

        System.out.println("컨티뉴");
    }

}
