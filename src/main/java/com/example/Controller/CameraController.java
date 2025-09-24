package com.example.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Camera;
import com.example.Repository.CameraRepository;

@RestController
@RequestMapping("/cameras")
@CrossOrigin(origins = "http://localhost:3003")
public class CameraController {
	
	private final CameraRepository repo;

    public CameraController(CameraRepository repo) { this.repo = repo; }

    @GetMapping("/getAll")
    public List<Camera> getAll() { return repo.findAll(); }

    @PostMapping("/save")
    public Camera create(@RequestBody Camera cam) { return repo.save(cam); }

    @PutMapping("/update/{id}")
    public Camera update(@PathVariable Long id, @RequestBody Camera cam) {
        cam.setId(id);
        return repo.save(cam);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }

    @PostMapping("/{id}/start")
    public Map<String,String> start(@PathVariable Long id) {
        return Map.of("message", "Camera " + id + " started");
    }

    @PostMapping("/{id}/stop")
    public Map<String,String> stop(@PathVariable Long id) {
        return Map.of("message", "Camera " + id + " stopped");
    }
}


