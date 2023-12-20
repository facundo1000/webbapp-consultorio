package edu.unam.webbapp.consultorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebbappConsultorioApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebbappConsultorioApplication.class, args);
    }

}



