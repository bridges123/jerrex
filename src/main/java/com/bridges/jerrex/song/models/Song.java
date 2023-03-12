package com.bridges.jerrex.song.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

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
    private String name;

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

//    @OneToMany()
//    private List<Annotation> annotations;

//    @ManyToMany()
//    private List<Tag> tags;

//    @NotEmpty
//    @ManyToMany()
//    private List<User> authors;

//    @ManyToMany()
//    private List<User> features;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Album album;

//    @ManyToMany()
//    private List<User> producers;

}