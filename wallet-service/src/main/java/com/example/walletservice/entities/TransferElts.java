package com.example.walletservice.entities;

import com.example.walletservice.model.Transfer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferElts {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long TransferId;
    @Transient
    private Transfer transfer;
    private double amount;
    private String sourceWalletId;
    private String destinationWalletId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Wallet wallet;
}
