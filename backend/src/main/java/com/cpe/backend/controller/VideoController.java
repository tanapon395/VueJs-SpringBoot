package com.cpe.backend.controller;

import com.cpe.backend.entity.Video;
import com.cpe.backend.repository.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class VideoController {

    @Autowired
    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/video")
    public Collection<Video> Videos() {
        return videoRepository.findAll().stream().collect(Collectors.toList());
    }

}