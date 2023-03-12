package com.bridges.jerrex.song.controllers;

import com.bridges.jerrex.song.models.Song;
import com.bridges.jerrex.song.repos.SongRepo;
import com.bridges.jerrex.song.responses.LyricsResponse;
import com.bridges.jerrex.song.responses.Meta;
import com.bridges.jerrex.song.responses.Response;
import com.bridges.jerrex.song.responses.SongResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/song")
public class SongRestController {
    private final SongRepo songRepo;

    public SongRestController(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    @GetMapping("/{id}")
    public Response getSongById(@PathVariable Long id) throws EntityNotFoundException {
        Song song = songRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Song with id = %d not found.".formatted(id))
        );
        return new Response(
                new Meta(HttpStatus.OK.value()),
                new SongResponse(song)
        );
    }

    @GetMapping("/lyrics/{id}")
    public Response getSongLyricsById(@PathVariable Long id) throws EntityNotFoundException {
        Song song = songRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Song with id = %d not found.".formatted(id))
        );
        return new Response(
                new Meta(HttpStatus.OK.value()),
                new LyricsResponse(song.getLyrics())
        );
    }
}
