package medi.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medi.voll.api.domain.consulta.DadosAgendamentoConsulta;
import medi.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

}
