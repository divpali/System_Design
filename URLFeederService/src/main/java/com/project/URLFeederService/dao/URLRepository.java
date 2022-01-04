package com.project.URLFeederService.dao;

import com.project.URLFeederService.model.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URLEntity, String> {
}
