/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;
import softwarecorporativo.entidade.CorProduto;
import softwarecorporativo.servico.CorProdutoServico;
import java.util.List;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "CorProdutoBean")
public class CorProdutoBean extends Bean<CorProduto> implements Serializable{
    
    @Inject
    private CorProdutoServico corProdutoServico;
    
    private List<CorProduto> cores;

    @Override
    protected boolean salvar(CorProduto entidade) {
        corProdutoServico.persistirCorProduto(entidade);
        return true; 
    }

    @Override
    protected boolean atualizar(CorProduto entidade) {
        corProdutoServico.atualizarCor(entidade);
        return true;
    }

    @Override
    protected boolean deletar(CorProduto entidade) {
       corProdutoServico.deletar(entidade);
       return true;
    }

    @Override
    protected void iniciarCampos() {
    corProdutoServico.criar();
    }
     public List<CorProduto> getCor(){
        return corProdutoServico.getCores();
    }
}
