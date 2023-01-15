package com.boys.esa.repo;

import com.boys.esa.models.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotification, UUID> {

}
