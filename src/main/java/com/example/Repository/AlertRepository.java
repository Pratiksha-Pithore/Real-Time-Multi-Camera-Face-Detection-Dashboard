package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Alert;

@Repository
public interface AlertRepository  extends JpaRepository<Alert, Long> {
    List<Alert> findByCameraId(Long cameraId);
}
