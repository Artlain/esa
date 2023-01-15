package com.boys.esa.repo;

import com.boys.esa.models.LogRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogRowRepository extends JpaRepository<LogRow, UUID> {

}
