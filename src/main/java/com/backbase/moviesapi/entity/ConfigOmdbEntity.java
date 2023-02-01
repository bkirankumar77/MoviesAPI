package com.backbase.moviesapi.entity;

import com.backbase.moviesapi.enums.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Configuration OMDB entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@DynamicUpdate
@Entity
@Table(name = "config_omdb")
public class ConfigOmdbEntity {

    @Id
    private int id;

    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(insertable = false)
    private boolean enable;

    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;

}
