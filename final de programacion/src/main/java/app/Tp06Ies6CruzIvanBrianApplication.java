package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"app", "models"}) // Escanea los paquetes que contienen tus clases
public class Tp06Ies6CruzIvanBrianApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tp06Ies6CruzIvanBrianApplication.class, args);
    }
}
