package com.bridges.jerrex.song.repos;

import com.bridges.jerrex.song.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
    Optional<Song> findById(long id);
}
