package com.example.SpringBoot_Study.Repository;

import com.example.SpringBoot_Study.Entity.testEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<testEntity, String> {

}
