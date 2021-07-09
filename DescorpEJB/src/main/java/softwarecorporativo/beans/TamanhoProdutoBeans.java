/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import softwarecorporativo.entidade.TamanhoProduto;
import softwarecorporativo.servico.TamanhoServico;
import java.util.List;

/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "TamanhoProdutoBean")
public class TamanhoProdutoBeans extends Beans<TamanhoProduto> implements Serializable   {

    private TamanhoServico tamanhoServico;
    private List<TamanhoProduto> tamanhos;
    
    @Override
    protected boolean salvar(TamanhoProduto entidade) {
    tamanhoServico.persistirTamanhoProduto(entidade);
    return true;
    }

    @Override
    protected boolean atualizar(TamanhoProduto entidade) {
      tamanhoServico.atualizarTamanho(entidade);
      return true;
    }

    @Override
    protected boolean deletar(TamanhoProduto entidade) {
      tamanhoServico.deletar(entidade);
      return true;
    }

    @Override
    protected void iniciarCampos() {
    tamanhoServico.criar();
    }
     public List<TamanhoProduto> getTamanhoProdutos(){
        return tamanhoServico.getTamanhos();
    }
}