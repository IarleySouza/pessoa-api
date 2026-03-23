package pessoa.api.infrastructure.dtos;

public record PessoaDTOs(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf
) {
}
