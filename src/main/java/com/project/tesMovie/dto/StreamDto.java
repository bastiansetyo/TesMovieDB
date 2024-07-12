package com.project.tesMovie.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StreamDto {
        private List<String> request = new ArrayList<>();
        private List<Integer> numm = new ArrayList<>();
        private String rahasia;
        private String rahasia2;

}
