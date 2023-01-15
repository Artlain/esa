package com.boys.esa.models;



import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name = "SURNAME")
    private String surname;

    @NonNull
    @Column(name = "COUNTRY")
    private String country;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
}
