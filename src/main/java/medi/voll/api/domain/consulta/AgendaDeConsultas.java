package medi.voll.api.domain.consulta;

import medi.voll.api.domain.ValidacaoException;
import medi.voll.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import medi.voll.api.domain.medico.Medico;
import medi.voll.api.domain.medico.MedicoRepository;
import medi.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public void agendar(DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente inexistente");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do medico inexistente");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);

        consultaRepository.save(consulta);
    }

    public void cancelar(DadosCancelamentoConsulta dados){
        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoException("Id da consulta inexistente");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null){
            throw new ValidacaoException("Especialidade não informada!");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }


}
