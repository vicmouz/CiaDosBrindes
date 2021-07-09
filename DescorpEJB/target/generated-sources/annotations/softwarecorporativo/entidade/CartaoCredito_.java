package softwarecorporativo.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwarecorporativo.entidade.ClienteUsuario;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2021-07-03T22:36:38")
@StaticMetamodel(CartaoCredito.class)
public class CartaoCredito_ extends Entidade_ {

    public static volatile SingularAttribute<CartaoCredito, Date> dataExpiracao;
    public static volatile SingularAttribute<CartaoCredito, String> numero;
    public static volatile SingularAttribute<CartaoCredito, ClienteUsuario> usuario;
    public static volatile SingularAttribute<CartaoCredito, Long> id;
    public static volatile SingularAttribute<CartaoCredito, String> bandeira;

}