package co.istad.chhaya.fswd_sbapp.swaggers;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Moung Meyneang",
                version = "2.0",
                description = "REST API documentation for my Spring Boot project.",
                contact = @Contact(
                        name = "Moung Meyneang",
                        email = "your@email.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://springdoc.org"
                )
        )
)
public class ConfigApi {
}
