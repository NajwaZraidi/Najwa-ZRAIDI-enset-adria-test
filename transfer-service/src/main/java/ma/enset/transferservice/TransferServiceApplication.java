package ma.enset.transferservice;

import ma.enset.transferservice.entities.Transfer;
import ma.enset.transferservice.repositories.TransferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(TransferRepository transferRepository) {

		return args -> {
			// Exemples de création de transferts
			Transfer transfer1 = new Transfer();
			transfer1.setSourceWalletId("sourceWallet1");
			transfer1.setDestinationWalletId("destinationWallet1");
			transfer1.setAmount(100.0);
			transferRepository.save(transfer1);

			Transfer transfer2 = new Transfer();
			transfer2.setSourceWalletId("sourceWallet2");
			transfer2.setDestinationWalletId("destinationWallet2");
			transfer2.setAmount(200.0);
			transferRepository.save(transfer2);

			// Affichage les transferts
			System.out.println("Transfers created:");

			Iterable<Transfer> transfers = transferRepository.findAll();
			for (Transfer transfer : transfers) {
				System.out.println("Transfer ID: " + transfer.getId());
				System.out.println("Source Wallet: " + transfer.getSourceWalletId());
				System.out.println("Destination Wallet: " + transfer.getDestinationWalletId());
				System.out.println("Amount: " + transfer.getAmount());
				System.out.println("--------------------------");
			}
		};
	}
}
