package br.com.ifpe.oxefood.api.fornecedor;
import java.time.LocalDate;

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
@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin

public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;
   
 @PostMapping
   public ResponseEntity<Fornecedor> save(@RequestBody FornecedorRequest request) {

       Fornecedor fornecedor = fornecedorService.save(request.build());
       return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
   }

}
