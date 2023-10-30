package ma.enset.clientservice;

import ma.enset.clientservice.entities.Client;
import ma.enset.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository){

        return args -> {
            clientRepository.save(new Client(null,"Awjan","KAMIS","Awjan@gmail.com"));
            clientRepository.save(new Client(null,"Islam","ZRAIDI","zraidi@gmail.com"));
            clientRepository.save(new Client(null,"Ouadie","ALAMI","alami@gmail.com"));
            clientRepository.saveAll(List.of(
                    Client.builder ().prénom("Mohamed").nom("alami").email("med@gmail.com").build(),
                    Client.builder ().prénom("Hassan").nom("alaoui").email("hasan@gmail.com").build(),
                    Client.builder ().prénom("IMane").nom("bennis").email("imane@gmail.com").build()
            ));

            System.out.println(" ---------------- Les clients ------------------ ");
            clientRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });

        };
    }
}
