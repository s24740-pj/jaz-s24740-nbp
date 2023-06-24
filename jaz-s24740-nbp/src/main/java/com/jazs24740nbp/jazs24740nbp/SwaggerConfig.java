package com.jazs24740nbp.jazs24740nbp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("s24740@pjwstk.edu.pl");
        contact.setName("s24740 Kamil Powierza");
        contact.setUrl("https://github.com/s24740-pj");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Currency Service API")
                .version("1.0")
                .contact(contact)
                .description("Currency service api.").termsOfService("https://github.com/s24740-pj")
                .license(mitLicense);

        return new OpenAPI().info(info);
    }
}
