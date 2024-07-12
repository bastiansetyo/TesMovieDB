package com.project.tesMovie.controller;

import com.project.tesMovie.dto.HariDto;
import com.project.tesMovie.dto.TestDto;
import com.project.tesMovie.dto.concatDto;
import com.project.tesMovie.service.CalenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestCalenderController {
    @Autowired
    private CalenderService calenderService;

    @PostMapping("/InputDate")
    public String Date(@RequestBody String hehe) {
    return calenderService.DateHidden(hehe);
    }

    @GetMapping("/Kalkulator")
    public Integer kalku() {
        return calenderService.kalkuHidden();
    }

    @PostMapping("/Kalku")
    public String hasil(@RequestBody TestDto input) {
        return calenderService.hasilHidden(input);
    }

    @PostMapping("/String")
    public String hasil(@RequestBody String input) {
        return calenderService.HasilHidden(input);
    }

    @PostMapping("/ManipulasiTanggal")
    public String hasill(@RequestBody HariDto iinput) throws Exception{
        return calenderService.ManipulasiTanggal(iinput);
    }

    @PostMapping("/concat")
    public String concat(@RequestBody concatDto input){
        return calenderService.concat(input);
    }

    @PostMapping("/manipulasibulan")
    public List<String> manipulasi(@RequestBody HariDto input){
        return calenderService.manipulasiBulan(input);
    }
}

