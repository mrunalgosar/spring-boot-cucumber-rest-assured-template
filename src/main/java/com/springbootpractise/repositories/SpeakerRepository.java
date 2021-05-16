package com.springbootpractise.repositories;

import com.springbootpractise.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    void deleteByFirstName(String firstName);
}
