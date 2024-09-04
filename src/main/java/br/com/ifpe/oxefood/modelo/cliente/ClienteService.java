package br.com.ifpe.oxefood.modelo.cliente;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.modelo.mensagens.EmailService;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

     @Autowired
    private EmailService emailService;

    
    @Transactional
   public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       cliente.setVersao(1L);
       cliente.setDataCriacao(LocalDate.now());
       Cliente clienteSalvo = repository.save(cliente);

       emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);

       return clienteSalvo;
   }

     @Autowired
   private ClienteRepository repository;

   @Autowired
private UsuarioService usuarioService;


   @Transactional
   public Cliente save(Cliente cliente, Usuario usuarioLogado) {

    usuarioService.save(cliente.getUsuario());

       cliente.setHabilitado(Boolean.TRUE);
       cliente.setVersao(1L);
       cliente.setDataCriacao(LocalDate.now());
       cliente.setCriadoPor(usuarioLogado);
       return repository.save(cliente);
   }
   public List<Cliente> listarTodos() {
  
    return repository.findAll(); 
}

public Cliente obterPorID(Long id) {

    return repository.findById(id).get();
}
@Transactional
public void update(Long id, Cliente clienteAlterado,Usuario usuarioLogado) {

   Cliente cliente = repository.findById(id).get();
   cliente.setNome(clienteAlterado.getNome());
   cliente.setDataNascimento(clienteAlterado.getDataNascimento());
   cliente.setCpf(clienteAlterado.getCpf());
   cliente.setFoneCelular(clienteAlterado.getFoneCelular());
   cliente.setFoneFixo(clienteAlterado.getFoneFixo());
   cliente.setVersao(cliente.getVersao() + 1);
   cliente.setDataUltimaModificacao(LocalDate.now());
   cliente.setUltimaModificacaoPor(usuarioLogado);

   repository.save(cliente);
}

@Transactional
   public void delete(Long id) {

       Cliente cliente = repository.findById(id).get();
       cliente.setHabilitado(Boolean.FALSE);
       cliente.setVersao(cliente.getVersao() + 1);

       repository.save(cliente);
   }



}
