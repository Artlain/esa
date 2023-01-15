package com.boys.esa.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "EMAIL_NOTIFICATION")
@Getter
@Setter
public class EmailNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @NonNull
    @Column(name = "ADDRESS")
    private String address;

    @NonNull
    @Column(name = "CONTENT")
    private String content;

    @Override
    public String toString() {
        return String.format("Email{address=%s, content=%s}", address, content);
    }
}
