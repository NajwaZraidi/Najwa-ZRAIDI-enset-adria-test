package com.example.walletservice.repository;

import com.example.walletservice.entities.TransferElts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransferEltsRepository extends JpaRepository<TransferElts,Long> {
}
