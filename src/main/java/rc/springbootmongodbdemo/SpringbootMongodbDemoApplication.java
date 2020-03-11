package rc.springbootmongodbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class SpringbootMongodbDemoApplication {
    public SpringbootMongodbDemoApplication(){
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbDemoApplication.class, args);
    }

}
