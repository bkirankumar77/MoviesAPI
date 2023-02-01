package com.backbase.moviesapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@DynamicUpdate
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private int id;

    private String username;

    private String password;

    @CreationTimestamp
    private java.sql.Timestamp createdAt;

}
