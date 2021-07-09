package softwarecorporativo.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwarecorporativo.entidade.reputacaoLoja;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2021-07-03T22:36:38")
@StaticMetamodel(Loja.class)
public class Loja_ extends Entidade_ {

    public static volatile SingularAttribute<Loja, Date> dataInclusao;
    public static volatile SingularAttribute<Loja, String> nome;
    public static volatile SingularAttribute<Loja, Long> id;
    public static volatile SingularAttribute<Loja, String> cnpj;
    public static volatile SingularAttribute<Loja, reputacaoLoja> reputacao;
    public static volatile SingularAttribute<Loja, String> descricao;

}