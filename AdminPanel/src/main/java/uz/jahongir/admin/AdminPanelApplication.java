package uz.jahongir.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"uz.jahongir.library", "uz.jahongir.admin"})
@EntityScan(basePackages = "uz.jahongir.library.entities")
@EnableJpaRepositories(basePackages = "uz.jahongir.library.repositories")
public class AdminPanelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminPanelApplication.class, args);
    }

}
