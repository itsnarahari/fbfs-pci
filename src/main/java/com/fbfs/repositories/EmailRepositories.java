package com.fbfs.repositories;

import com.fbfs.entities.Emails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepositories extends JpaRepository<Emails, Long> {
}
