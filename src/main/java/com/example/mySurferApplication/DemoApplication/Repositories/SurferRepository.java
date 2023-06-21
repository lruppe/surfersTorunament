package com.example.mySurferApplication.DemoApplication.Repositories;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collection;

@EnableJpaRepositories(basePackages = "com.example.mySurferApplication.DemoApplication.Repositories")
public interface SurferRepository extends JpaRepository<Surfer, Long> {
    @Query("Select s From Surfer s WHERE s.gender = 'm'")
    Collection<Surfer> findMaleSurfers();

}
