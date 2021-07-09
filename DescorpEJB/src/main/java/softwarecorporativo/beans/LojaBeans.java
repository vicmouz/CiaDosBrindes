/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import softwarecorporativo.entidade.Loja;
import softwarecorporativo.servico.LojaServico;

/**
 *
 * @author T-Gamer
 */
@RequestScoped
@Named(value = "LojaBean")
public class LojaBeans extends Beans<Loja> implements Serializable {

    private LojaServico lojaServico;
    private List<Loja> lojas;
    
    @Override
    protected boolean salvar(Loja entidade) {
      lojaServico.persistirLoja(entidade);
      return true;
    }

    @Override
    protected boolean atualizar(Loja entidade) {
       lojaServico.atualizarLoja(entidade);
       return true;
    }

    @Override
    protected boolean deletar(Loja entidade) {
      lojaServico.deletar(entidade);
      return true;
    }

    @Override
    protected void iniciarCampos() {
        lojaServico.criar();
    }
     public List<Loja> getPedidos(){
        return lojaServico.getLojas();
    }
}