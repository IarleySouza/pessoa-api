package pessoa.api.infrastructure.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pessoa.api.core.domain.entities.Pessoa;
import pessoa.api.core.domain.gateways.PessoaGateway;
import pessoa.api.infrastructure.persistence.PessoaEntity;
import pessoa.api.infrastructure.persistence.PessoaRepository;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryGateway implements PessoaGateway {

    private final PessoaRepository pessoaRepository;
    private final PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
        var pessoaEntity = pessoaEntityMapper.toEntity(pessoa);
        var novaPessoa = pessoaRepository.save(pessoaEntity);
        return pessoaEntityMapper.toDomain(novaPessoa);
    }

    @Override
    public Pessoa findByCpf(String cpf) {
        PessoaEntity pessoaEntity = pessoaRepository.findByCpf(cpf);
        if (pessoaEntity == null) {
            return null;
        }
        return pessoaEntityMapper.toDomain(pessoaEntity);
    }

    @Override
    public List<Pessoa> allPessoa() {
        return pessoaRepository.findAll().stream()
                .map(pessoaEntityMapper::toDomain)
                .toList();
    }
}
