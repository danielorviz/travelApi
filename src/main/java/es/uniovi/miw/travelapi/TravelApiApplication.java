package es.uniovi.miw.travelapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**dd
 *
 */
@SpringBootApplication
public class TravelApiApplication {

    @Value("${amadeus.client.secret}")
    private String amadeusClientSecret;

    public static void main(String[] args) {
        SpringApplication.run(TravelApiApplication.class, args);
    }

    @Bean
    public String print(){
        System.out.println(this.amadeusClientSecret);
        return "";
    }

}
