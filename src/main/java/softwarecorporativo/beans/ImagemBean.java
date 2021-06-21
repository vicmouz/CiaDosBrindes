/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;
import java.io.Serializable;
import softwarecorporativo.entidade.ImagemProduto;
import softwarecorporativo.servico.ImagemServico;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "ImagemBean")
public class ImagemBean extends Bean<ImagemProduto> implements Serializable {

    private ImagemServico imagemServico;
    
    private List<ImagemProduto> imagens;
    
    @Override
    protected boolean salvar(ImagemProduto entidade) {
     imagemServico.persistirImagem(entidade);
     return true;
    }

    @Override
    protected boolean atualizar(ImagemProduto entidade) {
    imagemServico.atualizarImagem(entidade);
    return true;
    }

    @Override
    protected boolean deletar(ImagemProduto entidade) {
       imagemServico.deletar(entidade);
        return true;
    }

    @Override
    protected void iniciarCampos() {
       imagemServico.criar();
    }
     public List<ImagemProduto> getImagens(){
        return imagemServico.getImagens();
    }
}
