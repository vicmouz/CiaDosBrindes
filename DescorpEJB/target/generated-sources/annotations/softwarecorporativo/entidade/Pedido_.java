package softwarecorporativo.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwarecorporativo.entidade.ClienteUsuario;
import softwarecorporativo.entidade.Produto;
import softwarecorporativo.entidade.StatusPedido;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2021-07-03T22:36:38")
@StaticMetamodel(Pedido.class)
public class Pedido_ extends Entidade_ {

    public static volatile ListAttribute<Pedido, Produto> produto;
    public static volatile SingularAttribute<Pedido, String> log;
    public static volatile SingularAttribute<Pedido, Long> id;
    public static volatile SingularAttribute<Pedido, ClienteUsuario> clienteusuario;
    public static volatile SingularAttribute<Pedido, Integer> quantidade;
    public static volatile SingularAttribute<Pedido, StatusPedido> status;

}