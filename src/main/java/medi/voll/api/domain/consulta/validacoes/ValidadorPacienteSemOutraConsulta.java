package medi.voll.api.domain.consulta.validacoes;

import medi.voll.api.domain.ValidacaoException;
import medi.voll.api.domain.consulta.ConsultaRepository;
import medi.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsulta {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia)
            throw new ValidacaoException("Paciente possui outra consulta no mesmo dia");
    }
}
