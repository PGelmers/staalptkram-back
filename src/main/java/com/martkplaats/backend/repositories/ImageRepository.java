package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
}
