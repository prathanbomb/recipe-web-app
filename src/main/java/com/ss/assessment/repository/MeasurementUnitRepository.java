package com.ss.assessment.repository;

import com.ss.assessment.models.entity.MeasurementUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnitEntity, Long> {
}