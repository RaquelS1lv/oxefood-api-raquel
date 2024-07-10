package br.com.ifpe.oxefood.modelo.fornecedor;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;

@Service

public class FornecedorService {
      @Autowired
   private FornecedorRepository repository;

   @Transactional
   public Fornecedor save(Fornecedor fornecedor) {

       fornecedor.setHabilitado(Boolean.TRUE);
       fornecedor.setVersao(1L);
      fornecedor.setDataCriacao(LocalDate.now());
       return repository.save(fornecedor);
   }

}
