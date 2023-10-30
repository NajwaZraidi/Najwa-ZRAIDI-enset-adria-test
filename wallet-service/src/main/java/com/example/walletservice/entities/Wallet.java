package com.example.walletservice.entities;

import com.example.walletservice.model.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.List;
import java.util.UUID;

@Entity
public class Wallet {
    @Id
    private UUID id;
    private double solde;
    private String dateCreation;
    private String devise;
    private Long clientId;
    @Transient
    //no prend pas en cosederation en jpa
    private Client client;

    @OneToMany(mappedBy = "wallet")
    private List<TransferElts> transferElts;

    // Getters and setters
}
