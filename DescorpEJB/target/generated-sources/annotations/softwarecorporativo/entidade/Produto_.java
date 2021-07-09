package softwarecorporativo.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwarecorporativo.entidade.CorProduto;
import softwarecorporativo.entidade.ImagemProduto;
import softwarecorporativo.entidade.Loja;
import softwarecorporativo.entidade.TamanhoProduto;
import softwarecorporativo.entidade.TipoProduto;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2021-07-03T22:36:38")
@StaticMetamodel(Produto.class)
public class Produto_ extends Entidade_ {

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile ListAttribute<Produto, TamanhoProduto> tamanho;
    public static volatile SingularAttribute<Produto, Double> porcentagemPromocao;
    public static volatile SingularAttribute<Produto, ImagemProduto> imgProduto;
    public static volatile SingularAttribute<Produto, Boolean> promocao;
    public static volatile ListAttribute<Produto, CorProduto> cor;
    public static volatile SingularAttribute<Produto, Loja> loja;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, TipoProduto> tipoProduto;
    public static volatile SingularAttribute<Produto, Integer> quantidade;
    public static volatile SingularAttribute<Produto, String> descricao;

}