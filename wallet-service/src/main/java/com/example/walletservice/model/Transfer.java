package com.example.walletservice.model;

import com.example.walletservice.enums.TransferStatus;
import lombok.Data;

import java.util.Date;

@Data
public class Transfer {
    private Long id;
    private Date date;
    private double amount;
    private String sourceWalletId;
    private String destinationWalletId;
    private TransferStatus status;

}
