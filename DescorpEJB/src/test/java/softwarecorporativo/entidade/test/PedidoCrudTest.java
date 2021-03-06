/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.entidade.test;

import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import softwarecorporativo.entidade.ClienteUsuario;
import softwarecorporativo.entidade.Pedido;
import softwarecorporativo.entidade.StatusPedido;
import softwarecorporativo.servico.ClienteServico;
import softwarecorporativo.servico.PedidoServico;

/**
 *
 * @author marcosbrasil98
 */
public class PedidoCrudTest extends Teste {
    private ClienteServico clienteservico;
    private PedidoServico pedidoServico;
    
    @Before
    public void setUp() throws NamingException {
        pedidoServico = (PedidoServico) container.getContext().lookup("java:global/classes/ejb/PedidoServico!softwarecorporativo.servico.PedidoServico");
    }
    @After
    public void tearDown() {
        pedidoServico = null;
    }
    
    
    
    
    
    @Test
    public void getPedidoPorLog() {
        Pedido pedido = pedidoServico.consultarPorLog("nff979767");
        assertNotNull(pedido);
        assertEquals("nff979767", pedido.getLog());
    }
    
   
    
    @Test
    public void getPedidoPorId() {
        assertNotNull(pedidoServico.consultarPorId(new Long(2)));
    }
    
    /*@Test
    public void persistir() {   
        ClienteUsuario cliente =  clienteservico.consultarPorId(new Long(4));
        Pedido pedido = pedidoServico.criar();
        pedido.setId(7l);
        pedido.setLog("232432knsfksnfs");
        pedido.setQuantidade(340);
        pedido.setUsuario(cliente);
        pedido.setStatus(StatusPedido.ENTREGUE);
        pedidoServico.persistirPedido(pedido);
        assertNotNull(pedido.getId());
        
    }*/
    
    @Test
    public void atualizar() {
        Pedido pedido = pedidoServico.consultarPorId(new Long(2));
        pedido.setLog("20190530MB"); 
        pedidoServico.atualizarPedido(pedido);
        pedido = pedidoServico.consultarPorId(new Long(2));
        assertEquals("20190530MB", pedido.getLog());
    }
    
   
    
}