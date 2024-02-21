package com.example.Extreme.repos;

import com.example.Extreme.models.Klub;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KlubRepository extends JpaRepository<Klub, Long> {
    Optional<Klub> findKlubByGlownyTrue();
}
