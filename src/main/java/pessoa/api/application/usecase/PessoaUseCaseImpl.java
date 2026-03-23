package pessoa.api.application.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        Pessoa pessoa1 = pessoaGateway.findByCpf(pessoa.getCpf());
        var status = HttpStatus.OK;
        if (pessoa1 != null) {
            status = HttpStatus.NOT_FOUND;
            throw new BusinessException("Ja existe uma pessoa com esse CPF" +  pessoa.getCpf() + " cadastrado!" + " Status: " + status);
        }
        log.info("Status: {}", status.value());
        return pessoaGateway.createPessoa(pessoa);
    }

    @Override
    public List<Pessoa> findAllPessoa() {
        return pessoaGateway.allPessoa();
    }
}
