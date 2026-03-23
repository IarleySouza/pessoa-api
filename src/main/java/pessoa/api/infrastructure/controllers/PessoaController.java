package pessoa.api.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pessoa.api.application.usecase.PessoaUseCase;
import pessoa.api.core.domain.entities.Pessoa;
import pessoa.api.infrastructure.dtos.PessoaDTOs;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class PessoaController {

    private final PessoaDtoMapper pessoaDtoMapper;
    private final PessoaUseCase  pessoaUseCase;

    public PessoaController(PessoaDtoMapper pessoaDtoMapper, PessoaUseCase pessoaUseCase) {
        this.pessoaDtoMapper = pessoaDtoMapper;
        this.pessoaUseCase = pessoaUseCase;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PessoaDTOs>  create(@RequestBody PessoaDTOs pessoaDTOs) {
        Pessoa novaPessoa = pessoaUseCase.execute(pessoaDtoMapper.toDomain(pessoaDTOs));
        return new ResponseEntity<>(pessoaDtoMapper.toDto(novaPessoa),  HttpStatus.CREATED);
    }

    @GetMapping
    public List<PessoaDTOs> findAll() {
        return pessoaUseCase.findAllPessoa()
                .stream()
                .map(pessoaDtoMapper::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping(value = "/app")
    public ResponseEntity<String> app() {
        return ResponseEntity.ok("ok");
    }
    @GetMapping(value = "/v1/app")
    public ResponseEntity<String> findAllV1() {
        return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
    }

}
