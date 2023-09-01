package com.taskify.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    @NotNull
    @Min(1)
    private Long idUsuario;

    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

    private String numero;
    private String complemento;

}
