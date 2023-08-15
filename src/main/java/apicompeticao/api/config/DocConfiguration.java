package apicompeticao.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("competition API")
                        .description("API de competição")
                        .contact(new Contact()
                                .name("Esther Linhares")
                                .email("esther.s.linhares@gmail.com")));
    }
}
