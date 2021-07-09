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
import softwarecorporativo.entidade.CartaoCredito;
import softwarecorporativo.servico.CartaoCreditoServico;

/**
 *
 * @author T-Gamer
 */
@RequestScoped
@Named(value = "CartaoBean")
public class CartaoCreditoBeans extends Beans<CartaoCredito> implements Serializable{

    private CartaoCreditoServico cartaoServico;
    private List<CartaoCredito> produtos;
    @Override
    protected boolean salvar(CartaoCredito entidade) {
     cartaoServico.persistirCartaoCredito(entidade);
     return true;
    }

    @Override
    protected boolean atualizar(CartaoCredito entidade) {
    cartaoServico.atualizar(entidade);
    return true;
    }

    @Override
    protected boolean deletar(CartaoCredito entidade) {
    cartaoServico.deletar(entidade);
    return true;
    }

    @Override
    protected void iniciarCampos() {
    cartaoServico.criar();
    }
    public List<CartaoCredito> getProdutos(){
        return cartaoServico.getCartoes();
    }
}