package com.example.walletservice.web;


import com.example.walletservice.entities.Wallet;
import com.example.walletservice.model.Client;
import com.example.walletservice.model.Transfer;
import com.example.walletservice.repository.TransferEltsRepository;
import com.example.walletservice.repository.WalletRepository;
import com.example.walletservice.service.ClientRestClientService;
import com.example.walletservice.service.TransferRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletRestController {
    WalletRepository walletRepository;
    TransferEltsRepository transferEltsRepository;
    ClientRestClientService clientRestClientService;
    TransferRestClientService produitRestClientService;

    public WalletRestController(WalletRepository walletRepository, TransferEltsRepository transferEltsRepository, ClientRestClientService clientRestClientService, TransferRestClientService transferRestClientService) {
        this.walletRepository = walletRepository;
        this.transferEltsRepository = transferEltsRepository;
        this.clientRestClientService = clientRestClientService;
        this.produitRestClientService = produitRestClientService;
    }

    @GetMapping("/Wallet/{id}")
    public Wallet getWallet(@PathVariable Long id){
        Wallet Wallet=walletRepository.findById(id).orElse(null);
        Client client=clientRestClientService.clientById(Wallet.getClientId());
        Wallet.setClient(client);
        Wallet.getTransferElts().forEach(pi->{
            Transfer transfer=produitRestClientService.TransferById(pi.getTransferId());
            pi.setTransfer(transfer);
        });
        return Wallet;
    }


}
