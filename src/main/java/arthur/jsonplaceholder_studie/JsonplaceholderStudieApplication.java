package arthur.jsonplaceholder_studie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import records.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JsonplaceholderStudieApplication {

	private static final Logger log = LoggerFactory.getLogger(JsonplaceholderStudieApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JsonplaceholderStudieApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run (RestTemplate restTemplate) throws Exception {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonResponse = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
			List<User> usersList = objectMapper.readValue(jsonResponse, new TypeReference<List<User>>() {});
			for(User u : usersList) {
				log.info(u.toString());
			}
			List<entities.User> userObjectsJava = new ArrayList<>();
			for (User user : usersList) {
				userObjectsJava.add(new entities.User(Long.parseLong(String.valueOf(user.id())),
						String.valueOf(user.name()),
						String.valueOf(user.username()),
						String.valueOf(user.email()),
						String.valueOf(user.phone()),
						String.valueOf(user.website()),
						String.valueOf(user.address().street()),
						String.valueOf(user.address().suite()),
						String.valueOf(user.address().city()),
						String.valueOf(user.address().zipcode()),
						Double.parseDouble(String.valueOf(user.address().geo().lat())),
						Double.parseDouble(String.valueOf(user.address().geo().lnt())),
						String.valueOf(user.company().name()),
						String.valueOf(user.company().catchPhrase()),
						String.valueOf(user.company().bs())));
			}
			//List<Todos> todosList = objectMapper.readValue(jsonResponse, new TypeReference <List<Todos>>() {});

			};
		}
	};



