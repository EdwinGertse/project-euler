package com.tegres.project.euler.domain;

public class NumberLetterRequest {
    private Integer start;
    private Integer end;

    public NumberLetterRequest(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}
