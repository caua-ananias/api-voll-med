package medi.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medi.voll.api.medico.DadosCadastroMedico;
import medi.voll.api.medico.DadosListagemMedico;
import medi.voll.api.medico.Medico;
import medi.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> listarMedicos() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}
