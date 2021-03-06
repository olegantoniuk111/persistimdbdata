package ua.vin.persistimdbdata;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableBatchProcessing
public class PersistimdbdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistimdbdataApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}

}
