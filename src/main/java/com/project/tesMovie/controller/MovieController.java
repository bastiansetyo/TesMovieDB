package com.project.tesMovie.controller;

import com.project.tesMovie.dao.MovieDao;
import com.project.tesMovie.repository.MovieRepository;
import com.project.tesMovie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @GetMapping("/tampil")
    public List<MovieDao> tampil() {
        return movieService.TampilHidden();
    }

    @PostMapping("/Simpan")
    public List<MovieDao> simpan(@RequestBody MovieDao simpan) {
        return movieService.SimpanHidden(simpan);
    }

    @PostMapping("/tambahbangku")
    public ResponseEntity<?> tambah(@RequestBody MovieDao request) throws Exception {//setelah public adalah return MovieDao
        return  movieService.TambahHidden(request);
    }

    @PostMapping("/hapus")
    public List<MovieDao> hapus(@RequestBody Integer hapus) {
        return movieService.HapusHidden(hapus);
    }

    @PostMapping("/cari")
    public MovieDao cari(@RequestBody Integer id) {
        return movieService.CariHidden(id);
    }
//update ada idnyaaaaaa dan save response
}
