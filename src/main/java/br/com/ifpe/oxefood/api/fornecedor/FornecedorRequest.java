package br.com.ifpe.oxefood.api.fornecedor;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
 @JsonFormat(pattern = "dd/MM/yyyy")
public class FornecedorRequest {
    
}
