package br.com.rodrigocmo.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("RESTFULL API WITH JAVA")
                        .version("v1")
                        .description("Projeto rest usando java")
                        .termsOfService("Termos de serviço")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("Url")));
    }
}
