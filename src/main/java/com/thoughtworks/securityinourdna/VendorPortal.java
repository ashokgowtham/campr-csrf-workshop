package com.thoughtworks.securityinourdna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class VendorPortal {

    @Bean
    public UserRepo userRepo() {
        try {
            final ConnectionFactory connectionFactory = new ConnectionFactory();
            final UserRepo userRepo = new UserRepo(connectionFactory.createInMemoryDatabase());

            userRepo.addName("HVAC Company", "6b3a55e0261b0304143f805a24924d0c1c44524821305f31d9277843b8a10f4e");
            userRepo.addName("Electrician", "34c9b6ca63682155572447dbed32a8e6a91990982ec5b36a24c40dfe24595660");
            userRepo.addName("Recycling", "c16abba613aa32cf83b2b3bf164bc4873acf6ed2560a3563922f58915120e5c6");
            userRepo.addName("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");

            return userRepo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(VendorPortal.class);
        app.run(args);
    }
}
