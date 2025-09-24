package com.example.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Alert {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cameraId;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String bbox; // JSON string {x,y,w,h}

    private double confidence;

	public Alert() {
		super();
	}

	public Alert(Long id, Long cameraId, LocalDateTime timestamp, String bbox, double confidence) {
		super();
		this.id = id;
		this.cameraId = cameraId;
		this.timestamp = timestamp;
		this.bbox = bbox;
		this.confidence = confidence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCameraId() {
		return cameraId;
	}

	public void setCameraId(Long cameraId) {
		this.cameraId = cameraId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getBbox() {
		return bbox;
	}

	public void setBbox(String bbox) {
		this.bbox = bbox;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
    
}