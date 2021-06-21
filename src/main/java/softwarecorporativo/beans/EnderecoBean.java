/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;
import softwarecorporativo.entidade.EnderecoCliente;
import softwarecorporativo.servico.EnderecoServico;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "EnderecoBean")
public class EnderecoBean extends Bean<EnderecoCliente> implements Serializable {

    
     @Inject
    private EnderecoServico enderecoServico;

private List<EnderecoCliente> enderecos;
    @Override
    protected boolean salvar(EnderecoCliente entidade) {
        enderecoServico.persistirEndereco(entidade);
        return true;
       }

    @Override
    protected boolean atualizar(EnderecoCliente entidade) {
       enderecoServico.atualizarEndereco(entidade);
       return true;
    }

    @Override
    protected boolean deletar(EnderecoCliente entidade) {
        enderecoServico.deletar(entidade);
        return true;
    }

    @Override
    protected void iniciarCampos() {
    enderecoServico.criar();
    }
    
}
