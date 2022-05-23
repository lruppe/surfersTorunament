package com.example.mySurferApplication.DemoApplication.Repositories;

import com.example.mySurferApplication.DemoApplication.Surfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.mySurferApplication.DemoApplication.Repositories")
public interface SurferRepository extends JpaRepository<Surfer, Long> {


}
