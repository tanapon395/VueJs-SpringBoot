package com.cpe.backend.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="video")
public class Video {

    @Id
    @SequenceGenerator(name="video_seq",sequenceName="video_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="video_seq")  
    @Column(name = "VIDEO_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="code")
    private @NonNull String code;
    private @NonNull String title;
    private @NonNull String url;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "V_ID", insertable = true)
    private User videoUser;

   // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Playlist.class)
   // @JoinColumn(name = "playlist_ID")

  // @Column(name="Playlist_ID")
  // @JoinColumn(name="V_ID", referencedColumnName="VIDEO_ID", insertable = true)
   // private long playlistId;

// @ManyToOne(fetch = FetchType.EAGER, targetEntity = Playlist.class)
// @JoinColumn(name = "listVideo", nullable=false)
// @JsonBackReference
// private Playlist playlistId;

}
