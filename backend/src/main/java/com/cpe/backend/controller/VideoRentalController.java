package com.cpe.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.entity.Customer;
import com.cpe.backend.entity.Employee;
import com.cpe.backend.entity.RentalType;
import com.cpe.backend.entity.Video;
import com.cpe.backend.entity.VideoRental;
import com.cpe.backend.repository.CustomerRepository;
import com.cpe.backend.repository.EmployeeRepository;
import com.cpe.backend.repository.RentalTypeRepository;
import com.cpe.backend.repository.VideoRentalRepository;
import com.cpe.backend.repository.VideoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class VideoRentalController {
    @Autowired
    private final VideoRentalRepository videoRentalRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RentalTypeRepository rentalTypeRepository;

    VideoRentalController(VideoRentalRepository videoRentalRepository) {
        this.videoRentalRepository = videoRentalRepository;
    }

    @GetMapping("/videoRental")
    public Collection<VideoRental> VideoRentals() {
        return videoRentalRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/videoRental/{customer_id}/{employee_id}/{video_id}/{rentalType}")
    public VideoRental newVideoRental(VideoRental newVideoRental,
    @PathVariable long customer_id,
    @PathVariable long employee_id,
    @PathVariable long video_id,
    @PathVariable long rentalType) {
    //VideoRental newVideoRental = new VideoRental();

    Customer rentCustomer = customerRepository.findById(customer_id);
    Video video = videoRepository.findById(video_id);
    Employee createdBy = employeeRepository.findById(employee_id);
    RentalType type = rentalTypeRepository.findById(rentalType);

    newVideoRental.setCreatedBy(createdBy);
    newVideoRental.setVideo(video);
    newVideoRental.setRentDate(new Date());
    newVideoRental.setRentCustomer(rentCustomer);
    newVideoRental.setType(type);

    return videoRentalRepository.save(newVideoRental); //บันทึก Objcet ชื่อ VideoRental
    
    }
}