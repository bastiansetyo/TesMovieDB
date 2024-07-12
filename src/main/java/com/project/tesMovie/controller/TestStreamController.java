package com.project.tesMovie.controller;

import com.project.tesMovie.dto.Stream1Dto;
import com.project.tesMovie.dto.StreamDto;
import com.project.tesMovie.service.StreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestStreamController {

    @Autowired
    private StreamService serviceService;

    @GetMapping("/stream")
    public List<String> TestStream() {
        return serviceService.TestStreamHidden();
    }


    @PostMapping("/stream1")
    public Stream1Dto TestStream1(@RequestBody StreamDto request) {
        return serviceService.streamHidden(request);
    }
//        Integer stream = request.getNumm().stream()
//            .reduce(0, Integer::sum);
//        String stream1 = request.getRequest()
//                .stream()
//                .filter(s -> s.startsWith("a"))
//                .map(String::toUpperCase).toString();
//        if (request.isEquals()) {
//            return stream;
//        }
//        else
}


