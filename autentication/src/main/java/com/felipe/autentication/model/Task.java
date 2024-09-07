package com.felipe.autentication.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Description;
}
