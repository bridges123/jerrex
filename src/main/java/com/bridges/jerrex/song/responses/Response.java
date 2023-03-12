package com.bridges.jerrex.song.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Meta meta;
    private Object response;

    public Response(Meta meta) {
        this.meta = meta;
    }
}