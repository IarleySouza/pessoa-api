package pessoa.api.application.usecase;

import lombok.extern.slf4j.Slf4j;
import pessoa.api.core.domain.entities.Pessoa;
import pessoa.api.core.domain.exceptions.BusinessException;
import pessoa.api.core.domain.gateways.PessoaGateway;

import java.util.List;

@Slf4j
public class PessoaUseCaseImpl implements PessoaUseCase {

    private final PessoaGateway pessoaGateway;
    public PessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(Pessoa pessoa) {
        Pessoa pessoaExistente = pessoaGateway.findByCpf(pessoa.getCpf());
        if (pessoaExistente != null) {
            throw new BusinessException("Ja existe uma pessoa com esse CPF: " + pessoa.getCpf());
        }
        log.info("Criando nova pessoa com CPF: {}", pessoa.getCpf());
        return pessoaGateway.createPessoa(pessoa);
    }

    @Override
    public List<Pessoa> findAllPessoa() {
        return pessoaGateway.allPessoa();
    }
}
