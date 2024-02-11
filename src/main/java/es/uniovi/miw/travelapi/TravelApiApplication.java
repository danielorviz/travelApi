package es.uniovi.miw.travelapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**dd
 *
 */
@SpringBootApplication
public class TravelApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TravelApiApplication.class, args);
    }


}
