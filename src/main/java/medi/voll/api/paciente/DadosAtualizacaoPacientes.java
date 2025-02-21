package medi.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import medi.voll.api.endereco.DadosEndereco;


public record DadosAtualizacaoPacientes(@NotNull Long id,
                                        String nome,
                                        String telefone,
                                        DadosEndereco endereco) {
}
