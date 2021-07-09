package softwarecorporativo.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwarecorporativo.entidade.CartaoCredito;
import softwarecorporativo.entidade.EnderecoCliente;
import softwarecorporativo.entidade.Pedido;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2021-07-03T22:36:38")
@StaticMetamodel(ClienteUsuario.class)
public class ClienteUsuario_ extends UsuarioGeral_ {

    public static volatile ListAttribute<ClienteUsuario, Pedido> pedidoUsuario;
    public static volatile SingularAttribute<ClienteUsuario, EnderecoCliente> endereco;
    public static volatile SingularAttribute<ClienteUsuario, String> fixo;
    public static volatile SingularAttribute<ClienteUsuario, String> celular;
    public static volatile SingularAttribute<ClienteUsuario, CartaoCredito> cartaoCredito;
    public static volatile SingularAttribute<ClienteUsuario, Date> dataNascimento;

}