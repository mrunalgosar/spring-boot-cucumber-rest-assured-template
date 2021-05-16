package com.springbootpractise.repositories;

import com.springbootpractise.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByName(String name);

    void deleteByName(String name);
}
