package pessoa.api.core.domain.gateways;

import pessoa.api.core.domain.entities.Pessoa;
import java.util.List;

public interface PessoaGateway {
    Pessoa createPessoa(Pessoa pessoa);
    Pessoa findByCpf(String cpf);
    List<Pessoa> allPessoa();
}
