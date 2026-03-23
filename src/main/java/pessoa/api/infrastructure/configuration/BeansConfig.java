package pessoa.api.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pessoa.api.application.usecase.*;
import pessoa.api.core.domain.gateways.PessoaGateway;

@Configuration
public class BeansConfig {

    @Bean
    public PessoaUseCase  pessoaUseCase(PessoaGateway pessoaGateway) {
        return new PessoaUseCaseImpl(pessoaGateway);
    }
}
