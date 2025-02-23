package medi.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import medi.voll.api.domain.endereco.DadosEndereco;


public record DadosAtualizacaoPacientes(@NotNull Long id,
                                        String nome,
                                        String telefone,
                                        DadosEndereco endereco) {
}
