package medi.voll.api.controller;

import jakarta.validation.Valid;
import medi.voll.api.paciente.DadosCadastroPaciente;
import medi.voll.api.paciente.DadosListagemPacientes;
import medi.voll.api.paciente.Paciente;
import medi.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastroPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPacientes::new);
    }
}
