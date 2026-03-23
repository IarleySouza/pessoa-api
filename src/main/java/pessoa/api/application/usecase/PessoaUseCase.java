package pessoa.api.application.usecase;

import pessoa.api.core.domain.entities.Pessoa;
import java.util.List;

public interface PessoaUseCase {
    Pessoa execute(Pessoa pessoa);
    List<Pessoa> findAllPessoa();
}
