package com.bridges.jerrex.song.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {
    private Integer status;
    private String message;

    public Meta(Integer status) {
        this.status = status;
    }
}