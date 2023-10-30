package com.example.walletservice.service;


import com.example.walletservice.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "client-service")
public interface ClientRestClientService {

    @GetMapping("/clients/{id}?projection=client")
    public Client clientById(@PathVariable Long id);

    @GetMapping("/clients?projection=client")
    public PagedModel<Client> clients();

}
