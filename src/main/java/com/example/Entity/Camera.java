package com.example.Entity;

import jakarta.persistence.*;

@Entity
public class Camera {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rtspUrl;
    private String location;
    private boolean enabled = true;
	public Camera() {
		super();
	}
	public Camera(Long id, String name, String rtspUrl, String location, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.rtspUrl = rtspUrl;
		this.location = location;
		this.enabled = enabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRtspUrl() {
		return rtspUrl;
	}
	public void setRtspUrl(String rtspUrl) {
		this.rtspUrl = rtspUrl;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
    
}