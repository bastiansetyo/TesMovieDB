package com.project.tesMovie.service;

import com.project.tesMovie.dto.Stream1Dto;
import com.project.tesMovie.dto.StreamDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreamServiceImpl implements StreamService {

    @Override
    public Stream1Dto streamHidden(StreamDto request){
        Stream1Dto response = new Stream1Dto();
        response.setRequestt(request.getRequest());
        response.setNummm(request.getNumm());
        BeanUtils.copyProperties(request,response);
        return response;
    }

    public List<String> TestStreamHidden() {
        List<String> list = Arrays.asList("apel", "banana", "cherry", "durian", "anggur");
        return list.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }
}
