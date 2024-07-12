package com.project.tesMovie.service;

import com.project.tesMovie.dto.Stream1Dto;
import com.project.tesMovie.dto.StreamDto;

import java.util.List;

public interface StreamService {

    Stream1Dto streamHidden(StreamDto request);

    List<String> TestStreamHidden();
}

