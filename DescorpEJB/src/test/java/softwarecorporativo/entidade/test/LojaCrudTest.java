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
import softwarecorporativo.entidade.Loja;
import softwarecorporativo.entidade.reputacaoLoja;
import softwarecorporativo.servico.LojaServico;

public class LojaCrudTest extends Teste{
    
  private LojaServico lojaservico;
  
   @Before
    public void setUp() throws NamingException {
        lojaservico = (LojaServico) container.getContext().lookup("java:global/classes/ejb/LojaServico!softwarecorporativo.servico.LojaServico");
    }
  @After
    public void tearDown() {
        lojaservico = null;
    }
  /* @Test
    public void existeCliente() {
        ClienteUsuario cliente = clienteservico.criar();
        cliente.setCpf("767.170.840-22");
        assertTrue(clienteservico.existe(cliente));
    }*/
    
    @Test
    public void getLojaPorNome() {
       Loja loja = lojaservico.consultarPorNome("Borracharia do Zezinho");
        assertNotNull(loja);
        assertNotNull("86.774.611/0001-02",loja.getCnpj());
    }
    

    @Test
    public void getLojaPorId() {
        assertNotNull(lojaservico.consultarPorId(new Long(1)));
    }
    
    @Test
    public void persistir() {
        
        Loja loja = lojaservico.criar();
        loja.setCnpj("87.282.097/0001-50");
        Calendar c = Calendar.getInstance();
        loja.setDataInclusao(c.getTime());
        loja.setNome("Teste");
        loja.setReputacao(reputacaoLoja.PRATA);
        
        
        lojaservico.persistirLoja(loja);
        assertNotNull(loja.getId());
        
    }
    
    /*@Test
    public void atualizar() {
        Loja loja = lojaservico.consultarPorId(new Long(4));
        loja.setNome("mbf1998@gmail.com"); 
        lojaservico.atualizar(loja);
        loja = lojaservico.consultarPorId(new Long(4));
        assertEquals("mbf1998@gmail.com", loja.getNome());
    }*/
    
   
}