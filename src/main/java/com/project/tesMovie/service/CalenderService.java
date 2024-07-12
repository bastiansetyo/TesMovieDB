package com.project.tesMovie.service;

import com.project.tesMovie.dto.HariDto;
import com.project.tesMovie.dto.TestDto;
import com.project.tesMovie.dto.concatDto;

import java.text.ParseException;
import java.util.List;

public interface CalenderService {

    String DateHidden (String hehe);

    Integer kalkuHidden();

    String hasilHidden(TestDto input);

    String HasilHidden(String input);

    String ManipulasiTanggal(HariDto input) throws ParseException;

    String concat(concatDto input);

    List<String> manipulasiBulan (HariDto input);
}
