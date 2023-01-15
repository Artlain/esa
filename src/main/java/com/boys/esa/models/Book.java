package com.boys.esa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@JsonIgnoreProperties(value = "author")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @NonNull
    @Column(name = "PUBLISH_DATE")
    private Date publishDate;

    @NonNull
    @Column(name = "PAGE_COUNT")
    private Integer pageCount;

}
