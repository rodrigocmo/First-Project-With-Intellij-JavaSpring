package br.com.rodrigocmo.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration()
@RequestMapping(path = "/api-docs")
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
