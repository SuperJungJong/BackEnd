import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.SpecVersion
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("local")
@Configuration
class SwaggerConfig{

    @Bean
    fun openapi(): OpenAPI {
        return OpenAPI()
            .specVersion(SpecVersion.V31)
            .info(
                Info()
                    .title("Sherlock Homes - Apartment API")
            )
    }
}