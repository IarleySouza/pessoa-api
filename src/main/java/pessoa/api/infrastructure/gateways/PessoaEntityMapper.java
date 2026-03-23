package pessoa.api.infrastructure.gateways;

import org.springframework.stereotype.Component;
import pessoa.api.core.domain.entities.Pessoa;
import pessoa.api.infrastructure.persistence.PessoaEntity;

@Component
public class PessoaEntityMapper {
    public PessoaEntity toEntity(Pessoa pessoa) {
        return new PessoaEntity(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getTelefone(), pessoa.getEmail());
    }
     public Pessoa toDomain(PessoaEntity pessoaEntity) {
        return new Pessoa(pessoaEntity.getId(), pessoaEntity.getNome(), pessoaEntity.getCpf(), pessoaEntity.getTelefone(), pessoaEntity.getEmail());
    }
}
