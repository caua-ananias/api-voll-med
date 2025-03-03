package medi.voll.api.domain.consulta.validacoes;

import medi.voll.api.domain.ValidacaoException;
import medi.voll.api.domain.consulta.DadosAgendamentoConsulta;
import medi.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

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
