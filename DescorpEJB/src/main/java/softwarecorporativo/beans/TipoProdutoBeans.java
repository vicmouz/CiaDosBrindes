/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;
import java.io.Serializable;
import softwarecorporativo.entidade.TipoProduto;
import softwarecorporativo.servico.TipoProdutoServico;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "TipoProdutoBean")
public class TipoProdutoBeans extends Beans<TipoProduto> implements Serializable {

    private TipoProdutoServico tipoProdutoServico;
    private List<TipoProduto> tipos;
    
    @Override
    protected boolean salvar(TipoProduto entidade) {
    tipoProdutoServico.persistirTipoProduto(entidade);
    return true;
    }

    @Override
    protected boolean atualizar(TipoProduto entidade) {
       tipoProdutoServico.atualizarTipoProduto(entidade);
       return true;
    }

    @Override
    protected boolean deletar(TipoProduto entidade) {
      tipoProdutoServico.deletar(entidade);
      return true;
    }

    @Override
    protected void iniciarCampos() {
    tipoProdutoServico.criar();
    }
    public List<TipoProduto> getTipos(){
        return tipoProdutoServico.getTipos();
    }
}