package com.backbase.moviesapi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * MovieEntity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    private int id;

    private String title;

    private String year;

    private String released;

    private String genre;

    private String director;

    private String actors;

    private String language;

    private String awards;

    private Double imdbRating;

    private int imdbVotes;

    @Column(unique = true)
    private String imdbId;

    private int boxOffice;

    @Lob
    private byte[] image;

    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;

    @OneToMany(targetEntity = MovieRateEntity.class,
            fetch = FetchType.EAGER, mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieRateEntity> rates;

    public void setRates(List<MovieRateEntity> rates) {
        this.rates = rates;
    }

    public void addRate(MovieRateEntity rate) {
        if (this.rates == null) this.rates = new ArrayList<>();
        this.rates.add(rate);
    }

}
