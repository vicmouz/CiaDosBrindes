package softwarecorporativo.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwarecorporativo.entidade.FuncaoAdministrador;
import softwarecorporativo.entidade.Loja;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2021-07-03T22:36:38")
@StaticMetamodel(Administrador.class)
public class Administrador_ extends UsuarioGeral_ {

    public static volatile SingularAttribute<Administrador, FuncaoAdministrador> funcao;
    public static volatile SingularAttribute<Administrador, Loja> loja;
    public static volatile SingularAttribute<Administrador, String> permissao;

}