package softwarecorporativo.entidade.test;

import java.util.Calendar;
import javax.ejb.EJBException;
import javax.naming.NamingException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import softwarecorporativo.entidade.CartaoCredito;
import softwarecorporativo.entidade.ClienteUsuario;
import softwarecorporativo.servico.CartaoCreditoServico;


public class CartaoCreditoCrudTest extends Teste{
    
  private CartaoCreditoServico cartaoservico;
  
   @Before
    public void setUp() throws NamingException {
        cartaoservico = (CartaoCreditoServico) container.getContext().lookup("java:global/classes/ejb/CartaoCreditoServico!softwarecorporativo.servico.CartaoCreditoServico");
    }
  @After
    public void tearDown() {
        cartaoservico = null;
    }
  

    
    
    @Test
    public void persistir() {
        CartaoCredito cartao = cartaoservico.criar();
        cartao.setBandeira("VISA");
        Calendar c = Calendar.getInstance();
        cartao.setDataExpiracao(c.getTime());
        cartao.setNumero("5555266677778884");
           
        cartaoservico.persistirCartaoCredito(cartao);
        assertNotNull(cartao.getId());
        
    }
    
     @Test
    public void getCartaoPorId() {
        assertNotNull(cartaoservico.consultarPorId(new Long(1)));
    }
   
    @Test
    public void atualizar() {
        CartaoCredito cartao = cartaoservico.consultarPorId(new Long(1));
        cartao.setNumero("5255266677778884"); 
        cartaoservico.atualizar(cartao);
        cartao = cartaoservico.consultarPorId(new Long(1));
        assertEquals("4073020000000002", cartao.getNumero());
    }
  
    
}