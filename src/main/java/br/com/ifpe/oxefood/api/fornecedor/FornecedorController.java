package br.com.ifpe.oxefood.api.fornecedor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.modelo.fornecedor.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin

public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;
     @Operation(
    summary = "Serviço responsável por salvar fornecedores no sistema.",
    description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema."
)
 @PostMapping
   public ResponseEntity<Fornecedor> save(@RequestBody FornecedorRequest request) {

       Fornecedor fornecedor = fornecedorService.save(request.build());
       return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
   }

}
