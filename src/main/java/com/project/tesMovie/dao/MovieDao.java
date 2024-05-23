package com.project.tesMovie.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@Table(name = "film")
@AllArgsConstructor
@NoArgsConstructor
public class MovieDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_pelanggan;
    private String nama_movie;
    private Integer tempat_duduk;
    private Date waktu_pesan = new Date();

}
