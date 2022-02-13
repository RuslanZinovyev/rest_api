package com.example.rest_api;

import com.example.rest_api.model.Client;
import com.example.rest_api.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Configuration
@EnableAutoConfiguration()
@ComponentScan()
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ClientService clientService) {
        List<Client> clients = new ArrayList<>();

        Client john = new Client();
        john.setAge(22);
        john.setName("John Doe");
        john.setEmail("john.doe@gmail.com");

        Client ruslan = new Client();
        ruslan.setAge(37);
        ruslan.setName("Ruslan Zinovyev");
        ruslan.setEmail("ruslan.zinovyev@gmail.com");

        Client oliver = new Client();
        oliver.setAge(34);
        oliver.setName("Oliver Marshall");
        oliver.setEmail("oliver.marshall@gmail.com");

        Client joel = new Client();
        joel.setAge(54);
        joel.setName("Joel Miller");
        joel.setEmail("joel.miller@gmail.com");

        Client patrick = new Client();
        patrick.setAge(29);
        patrick.setName("Patrick Stevens");
        patrick.setEmail("patrick.stevens@gmail.com");

        Client gomer = new Client();
        gomer.setAge(47);
        gomer.setName("Gomer Simpson");
        gomer.setEmail("gomer.simpson@gmail.com");

        clients.add(john);
        clients.add(ruslan);
        clients.add(oliver);
        clients.add(joel);
        clients.add(patrick);
        clients.add(gomer);

        for (Client c :
             clients) {
            System.out.println(c);
        }


        return args -> clients.forEach(clientService::save);
    }


}
