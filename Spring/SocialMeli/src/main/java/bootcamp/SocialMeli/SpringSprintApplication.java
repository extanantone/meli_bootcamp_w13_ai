package bootcamp.SocialMeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSprintApplication.class, args);
	}

    @SpringBootTest
    static
    class SpringSprintApplicationTests {

        @Test
        void contextLoads() {
        }

    }
}
