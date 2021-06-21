/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;
import java.io.Serializable;
import softwarecorporativo.entidade.Produto;
import softwarecorporativo.servico.ProdutoServico;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "ProdutoBean")
public class ProdutoBean extends Bean<Produto> implements Serializable{

    private ProdutoServico produtoServico;
    private List<Produto> produtos;
    @Override
    protected boolean salvar(Produto entidade) {
     produtoServico.persistirProduto(entidade);
     return true;
    }

    @Override
    protected boolean atualizar(Produto entidade) {
    produtoServico.atualizar(entidade);
    return true;
    }

    @Override
    protected boolean deletar(Produto entidade) {
    produtoServico.deletar(entidade);
    return true;
    }

    @Override
    protected void iniciarCampos() {
    produtoServico.criar();
    }
    public List<Produto> getProdutos(){
        return produtoServico.getProdutos();
    }
}
