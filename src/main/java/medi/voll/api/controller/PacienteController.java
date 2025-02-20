package medi.voll.api.controller;

import jakarta.validation.Valid;
import medi.voll.api.paciente.DadosCadastroPaciente;
import medi.voll.api.paciente.Paciente;
import medi.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastroPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}
