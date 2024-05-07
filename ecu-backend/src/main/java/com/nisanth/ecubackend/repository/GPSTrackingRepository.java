package com.nisanth.ecubackend.repository;

import com.nisanth.ecubackend.entity.GPSTrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPSTrackingRepository extends JpaRepository<GPSTrackingEntity,Long> {
}
