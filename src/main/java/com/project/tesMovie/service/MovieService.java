package com.project.tesMovie.service;

import com.project.tesMovie.dao.MovieDao;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {
    //perintah tampil
    List<MovieDao> TampilHidden();

    //perintah simpan
    List<MovieDao> SimpanHidden(MovieDao simpan);

    //perintah hapus
    List<MovieDao> HapusHidden(Integer hapus);

    //perintah cari
    MovieDao CariHidden(Integer id);

    //dapat menempati bangku saat waktu yang ditentukan sudah habis
    ResponseEntity<?> TambahHidden(MovieDao request) throws Exception; //setelah public adalah return MovieDao

}
