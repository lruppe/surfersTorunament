package com.example.mySurferApplication.DemoApplication.Repositories;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.mySurferApplication.DemoApplication.Repositories")
public interface ContestRepository extends JpaRepository<Contest, Long> {


}
