package pessoa.api.infrastructure.controllers;

import org.springframework.stereotype.Component;
import pessoa.api.core.domain.entities.Pessoa;
import pessoa.api.infrastructure.dtos.PessoaDTOs;

@Component
public class PessoaDtoMapper {
    public PessoaDTOs toDto(Pessoa pessoa) {
        return new PessoaDTOs(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone(), pessoa.getCpf());
    }
    public Pessoa toDomain(PessoaDTOs pessoaDTO) {
        return new Pessoa(null, pessoaDTO.nome(), pessoaDTO.cpf(), pessoaDTO.telefone(), pessoaDTO.email());
    }
}
