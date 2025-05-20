package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.ApiGateway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiGatewayRepository extends JpaRepository<ApiGateway, Long> {

    Optional<ApiGateway> findById(Long id);
}
