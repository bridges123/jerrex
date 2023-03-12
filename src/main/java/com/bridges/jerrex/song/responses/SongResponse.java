package com.bridges.jerrex.song.responses;

import com.bridges.jerrex.song.models.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SongResponse {
    private Song song;
}