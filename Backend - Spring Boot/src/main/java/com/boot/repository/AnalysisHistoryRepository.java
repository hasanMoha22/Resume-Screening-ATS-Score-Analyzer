package com.boot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.entity.AnalysisHistory;

public interface AnalysisHistoryRepository 
        extends JpaRepository<AnalysisHistory, Long> {
}

