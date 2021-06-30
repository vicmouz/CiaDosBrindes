/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.servico;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import softwarecorporativo.entidade.CartaoCredito;

/**
 *
 * @author marcosbrasil98
 */
@Stateless(name = "ejb/CartaoCreditoServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class CartaoCreditoServico extends Servico<CartaoCredito> {
    
    @PostConstruct
    public void init() {
        super.setClasse(CartaoCredito.class);
    }

    @Override
    public CartaoCredito criar() {
        return new CartaoCredito();
    }
    
    @Override
    public boolean existe(@NotNull CartaoCredito cartao) {
        TypedQuery<CartaoCredito> query = entityManager.createNamedQuery(CartaoCredito.CartaoPorNumero, CartaoCredito.class);
        query.setParameter(1, cartao.getNumero());
        return !query.getResultList().isEmpty();
    }
    
    public void persistirCartaoCredito(CartaoCredito cartao) {
        entityManager.persist(cartao);
    }
    
     
    public CartaoCredito atualizarCartaoCredito(CartaoCredito cartao) {
        entityManager.merge(cartao);
        entityManager.flush();
        return cartao;
    }
     @TransactionAttribute(SUPPORTS)
    public CartaoCredito consultarPorNumero( String numero) {
        return super.consultarEntidade(new Object[] {numero}, CartaoCredito.CartaoPorNumero);
    }
    
}