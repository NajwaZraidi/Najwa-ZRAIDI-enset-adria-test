package com.example.walletservice.service;

import com.example.walletservice.model.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "transfer-service")
public interface WalletRestClientService {

    @GetMapping("/transfer/{id}?projection=transfer")
    public Transfer TransferById(@PathVariable Long id);

    @GetMapping("/Transfers?projection=Transfer")
    public PagedModel<Transfer> Transfers();

}
