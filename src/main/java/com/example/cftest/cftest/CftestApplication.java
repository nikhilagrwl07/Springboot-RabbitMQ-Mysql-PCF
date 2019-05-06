package com.example.cftest.cftest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CftestApplication implements CommandLineRunner {

    private final ApplicationRepository applicationRepository;

    public CftestApplication(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CftestApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Application newApp = new Application();
        newApp.setName("MyNewApp5");
        newApp.setDescription("This is a new application");
        applicationRepository.save(newApp);

        Application newApp2 = new Application();
        newApp2.setName("MyNewApp6");
        newApp2.setDescription("This is a new application2");
        applicationRepository.save(newApp2);
    }
}
