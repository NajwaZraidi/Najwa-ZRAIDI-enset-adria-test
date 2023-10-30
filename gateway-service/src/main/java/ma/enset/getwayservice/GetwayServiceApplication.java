package ma.enset.getwayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetwayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayServiceApplication.class, args);
    }
    //exemple :http://localhost:9999/client-service/clients
    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocatorDynamic(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties){
        return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
    }
}
