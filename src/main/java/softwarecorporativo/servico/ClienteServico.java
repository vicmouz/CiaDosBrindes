/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.servico;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.br.CPF;
import softwarecorporativo.entidade.ClienteUsuario;
import softwarecorporativo.entidade.EnderecoCliente;

/**
 *
 * @author marcosbrasil98
 */
@Stateless(name = "ejb/ClienteServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class ClienteServico extends Servico<ClienteUsuario> {
    
    @PostConstruct
    public void init() {
        super.setClasse(ClienteUsuario.class);
    }

    @Override
    public ClienteUsuario criar() {
        ClienteUsuario cliente = new ClienteUsuario();
        cliente.setEndereco(new EnderecoCliente());
        return cliente;
    }
    
    @Override
    public boolean existe(@NotNull ClienteUsuario cliente) {
        TypedQuery<ClienteUsuario> query = entityManager.createNamedQuery(ClienteUsuario.Clienteporcpf, ClienteUsuario.class);
        query.setParameter(1, cliente.getCpf());
        return !query.getResultList().isEmpty();
    }
    
    public void persistirCliente(ClienteUsuario cliente) {
        entityManager.persist(cliente);
    }
    
    public ClienteUsuario atualizarCliente(ClienteUsuario cliente) {
        entityManager.merge(cliente);
        entityManager.flush();
        return cliente;
    }
      public void deletar(ClienteUsuario clienteUsuario){
         if (existe(clienteUsuario)) {
           ClienteUsuario cliente = entityManager.merge(clienteUsuario);
            entityManager.remove(cliente);
            entityManager.flush();
        }
   }
    
    @TransactionAttribute(SUPPORTS)
    public ClienteUsuario consultarPorCPF(@CPF String cpf) {
        return super.consultarEntidade(new Object[] {cpf}, ClienteUsuario.Clienteporcpf);
    }
    
    @TransactionAttribute(SUPPORTS)
    public List<ClienteUsuario> getClientes() {
        return getEntidades(ClienteUsuario.CLIENTES);}

    
}
