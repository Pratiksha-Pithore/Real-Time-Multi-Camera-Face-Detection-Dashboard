package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Alert;
import com.example.Repository.AlertRepository;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "http://localhost:3003")
public class AlertController {
	
	 private final AlertRepository repo;

	    public AlertController(AlertRepository repo) { this.repo = repo; }

	    @GetMapping("/get")
	    public List<Alert> getAll(@RequestParam Optional<Long> cameraId) {
	        return cameraId.map(repo::findByCameraId).orElseGet(repo::findAll);
	    }

	    @PostMapping("/add")
	    public Alert create(@RequestBody Alert alert) { return repo.save(alert); }
	}


