/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import softwarecorporativo.entidade.ClienteUsuario;
import softwarecorporativo.entidade.EnderecoCliente;
import softwarecorporativo.servico.ClienteServico;

/**
 *
 * @author victor
 */
@Named(value = "clienteBean")
@RequestScoped
public class ClienteUsuarioBeans extends Beans<ClienteUsuario> implements Serializable {

    @Inject
    private ClienteServico clienteServico;
    private EnderecoCliente enderecoCliente = new EnderecoCliente();
    private List<ClienteUsuario> clientes;

    public ClienteServico getClienteServico() {
        return clienteServico;
    }

    public void setClienteServico(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    public EnderecoCliente getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(EnderecoCliente enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public List<ClienteUsuario> getClientes() {
        if (clientes == null) {
            clientes = clienteServico.getClientes();
        }
        return clientes;
    }

    public void setClientes(List<ClienteUsuario> clientes) {
        this.clientes = clientes;
    }

    
    @Override
    protected boolean salvar(ClienteUsuario entidade) {
        
        
            entidade.setEndereco(enderecoCliente);
        clienteServico.persistirCliente(entidade);
           
            return true;
       
   
        
    }

    @Override
    public boolean atualizar(ClienteUsuario entidade) {
        clienteServico.atualizarCliente(entidade);
        return true;
    }

    public String editar(ClienteUsuario entidade) {
        entidade = clienteServico.consultarPorId(entidade.getId());
        return "alterarAluno";
    }

    @Override
    public boolean deletar(ClienteUsuario entidade) {
        clienteServico.deletar(entidade);
        return true;
    }
    
    @Override
    protected void iniciarCampos() {
        setEntidade(clienteServico.criar());
    }
}