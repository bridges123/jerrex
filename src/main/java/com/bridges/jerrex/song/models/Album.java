package com.bridges.jerrex.song.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albums")
@NoArgsConstructor
@Getter
@Setter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @Column(name = "release_date")
    private Date releaseDate;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(name = "cover", columnDefinition = "bytea")
    private byte[] cover;

    @NotEmpty
    @OneToMany(mappedBy = "album")
    private List<Song> songs;

//    @NotEmpty
//    @ManyToMany()
//    private User author;
}
