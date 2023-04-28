package com.maraquepo.edc.jpa;

import com.maraquepo.edc.performance.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
}
