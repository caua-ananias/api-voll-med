package medi.voll.api.domain.consulta.validacoes.cancelamento;

import medi.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
