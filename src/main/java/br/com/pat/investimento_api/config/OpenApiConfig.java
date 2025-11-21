package br.com.pat.investimento_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Painel de Investimentos - Desafio Caixa Verso")
                        .description("API para simulação de investimentos, análise de perfil (Suitability) e recomendação de produtos.")
                        .contact(new Contact().name("Patrícia").email("patricia.pessoa@caixa.gov.br"))
                        .version("1.0.0"));
    }
}