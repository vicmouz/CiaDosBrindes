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
public class ProdutoBeans extends Beans<Produto> implements Serializable{

    private ProdutoServico produtoServico;
    private Produto cadastroProduto;
    private Produto selectionadoProduto;

    public ProdutoServico getProdutoServico() {
        return produtoServico;
    }

    public void setProdutoServico(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    public Produto getSelectionadoProduto() {
        return selectionadoProduto;
    }

    public void setSelectionadoProduto(Produto selectionadoProduto) {
        this.selectionadoProduto = selectionadoProduto;
    }

    public Produto getCadastroProduto() {
        return cadastroProduto;
    }

    public void setCadastroProduto(Produto cadastroProduto) {
        this.cadastroProduto = cadastroProduto;
    }
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
    this.cadastroProduto = new Produto();
    }
    public List<Produto> getProdutos(){
        return produtoServico.getProdutos();
    }
    public void setProduto(Produto produto) {
        this.produtoServico.criar();
    }
}