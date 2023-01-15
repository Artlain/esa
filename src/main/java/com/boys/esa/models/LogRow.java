package com.boys.esa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "LOG_ROW")
@Getter
@Setter
public class LogRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "ENTITY")
    private String entity;

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @Column(name = "MESSAGE")
    private String message;

    @Override
    public String toString() {
        return String.format("LogRow{entity='%s', eventType='%s', message='%s'}", entity, eventType, message);
    }
}
