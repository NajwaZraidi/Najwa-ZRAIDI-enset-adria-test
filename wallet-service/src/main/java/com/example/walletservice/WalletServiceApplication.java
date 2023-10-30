package com.example.walletservice;

import com.example.walletservice.entities.TransferElts;
import com.example.walletservice.entities.Wallet;
import com.example.walletservice.repository.TransferEltsRepository;
import com.example.walletservice.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class WalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}
     @Bean
	CommandLineRunner commandLineRunner(WalletRepository walletRepository, TransferEltsRepository transferEltsRepository){
		return args -> {
			// Exemple de création d'une entité Wallet
			Wallet wallet = Wallet.builder()
					.id(UUID.randomUUID())
					.solde(1000.0)
					.dateCreation("2023-10-30")
					.devise("USD")
					.clientId(1L)  // Remplacez ceci par le véritable ID du client
					.build();

			wallet = walletRepository.save(wallet);
			System.out.println("Wallet created: " + wallet);

			// Exemple de création d'une entité TransferElts
			TransferElts transferElts = TransferElts.builder()
					.amount(200.0)
					.sourceWalletId(wallet.getId().toString())
					.destinationWalletId("destinationWalletId")
					.build();

			transferElts = transferEltsRepository.save(transferElts);
			System.out.println("TransferElts created: " + transferElts);
		};
	 }
}
