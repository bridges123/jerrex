package com.bridges.jerrex.song.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "songs")
@NoArgsConstructor
@Getter
@Setter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    private Long views;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "edit_status")
    private Boolean editStatus;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(name = "cover", columnDefinition = "bytea")
    private byte[] cover;

    private String videoURL;

    @NotEmpty
    private String lyrics;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

//    @OneToMany()
//    private List<Annotation> annotations;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "song_tag",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

//    @NotEmpty
//    @ManyToMany()
//    private User author;

//    @ManyToMany()
//    private List<User> features;

//    @ManyToMany()
//    private List<User> producers;

    public Song(String title, String description, Long views, Date releaseDate, Boolean editStatus, byte[] cover, String videoURL, String lyrics) {
        this.title = title;
        this.description = description;
        this.views = views;
        this.releaseDate = releaseDate;
        this.editStatus = editStatus;
        this.cover = cover;
        this.videoURL = videoURL;
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", releaseDate=" + releaseDate +
                ", editStatus=" + editStatus +
                ", cover=" + Arrays.toString(cover) +
                ", videoURL='" + videoURL + '\'' +
                ", lyrics='" + lyrics + '\'' +
                '}';
    }
}