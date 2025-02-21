package medi.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import medi.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(@NotNull Long id,
                                     String nome,
                                     String telefone,
                                     DadosEndereco endereco) {
}
