package medi.voll.api.domain.consulta.validacoes.agendamento;

import medi.voll.api.domain.ValidacaoException;
import medi.voll.api.domain.consulta.DadosAgendamentoConsulta;
import medi.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser realizada com médico excluido");
        }
    }
}
