package com.bestofsky.demo.junit5example;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;
    private int limit;

    public StudyStatus getStatus() {
        return status;
    }

    public void setStatus(StudyStatus status) {
        this.status = status;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Study() {

    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("수강인원은 1명 이상이여야 한다.");
        }
    }
}
