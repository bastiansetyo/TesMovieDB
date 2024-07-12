package com.project.tesMovie.service;

import com.project.tesMovie.dao.MovieDao;
import com.project.tesMovie.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

//perintah tampil
    @Override
    public List<MovieDao> TampilHidden() {
        return movieRepository.findAll();
    }

//perintah simpan
    public List<MovieDao> SimpanHidden(MovieDao simpan) {
        movieRepository.save(simpan);
        return movieRepository.findAll();
    }

//perintah hapus
    public List<MovieDao> HapusHidden(Integer hapus) {
        movieRepository.deleteById(hapus);
        return movieRepository.findAll();
    }

//perintah cari
    public MovieDao CariHidden(Integer id) {
        MovieDao response = new MovieDao();
        Optional<MovieDao> dao = movieRepository.findById(id);
        if (dao.isPresent()) {
            response = dao.get();
        }
        return response;
    }

//perintah dapat menempati bangku pada saat waktu yang ditentukan habis
    public ResponseEntity<?> TambahHidden(MovieDao request) throws Exception {//setelah public adalah return MovieDao
        int kapasitas = 5;           // memasukkan nilai maximal
        Date date = new Date ();  //memasukkan tanggal baru date
        date.setDate(date.getDate() + 2); //date baru di set dibuat  data di dao + 2
        //boolean ismax = false;
        MovieDao response = new MovieDao(); //memasukkan respon baru ke dalam dao
        List<MovieDao> daoList = movieRepository.findAll(); // memasukkan repo
        if (getDao(daoList,request,date) != null) { //Jika daolist jadi stream trus ada salah satu dari data match maka true val jika objek sama pada tempat duduk di isi request dan waktu sekarang lebih besar dari waktu di list maka truee
            BeanUtils.copyProperties(getDao(daoList,request,date),response);//mencopyy property dari get dao
            response.setNama_pelanggan(request.getNama_pelanggan());
            response.setWaktu_pesan(date);
            movieRepository.save(response);
            return new ResponseEntity<>(response, HttpStatus.OK);//save tanpa id save save dengan id = update
        }
        else if (daoList.stream().anyMatch(bangku -> Objects.equals(bangku.getTempat_duduk(),request.getTempat_duduk())))
            return new ResponseEntity<>("Bangku sudah ADA", HttpStatus.BAD_REQUEST); // melempar pengecualian baru

        else if (kapasitas == daoList.size())//jika kapaasitas = list dao size
            // ismax = true;//
            return new ResponseEntity<>("Bangku sudah Penuhh", HttpStatus.BAD_REQUEST); // melempar pengecualian baru
        else {
            response.setTempat_duduk(request.getTempat_duduk());
            response.setNama_movie("Spiderman");
//                response.setWaktu_pesan(new Date());
            movieRepository.save(response);
        }

        return ResponseEntity.ok(daoList);  //mengembalikan atau output moviedao
        /*for (MovieDao data : daoList) {}*/
    }

    private MovieDao getDao(List<MovieDao> daoList, MovieDao request, Date date){ //moviedao penamaan list movie dao rewuest dan data
        MovieDao response = null; //moviedao respon jadi null
        Optional<MovieDao> dao = daoList.stream().filter(val -> Objects.equals(val.getTempat_duduk(), request.getTempat_duduk()) && (date //data opsional dao itu daolist dibongkar lalu di filter jika objek ada yang sama val ambil tempat duduk dan dari request dan tanggal
                .after(val.getWaktu_pesan()))).findFirst(); //jika tanggal sekarang sesudah dari dengan waktu di data base ambil data pertama yang ditemukan
        if(dao.isPresent()) //jika dao ada isinya atau true maka respon ambil yang ada didao
        {
            response = dao.get();
        }
        return response;
    }

}
