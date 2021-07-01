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
import org.hibernate.validator.constraints.br.CPF;
import softwarecorporativo.entidade.Loja;

/**
 *
 * @author marcosbrasil98
 */
@Stateless(name = "ejb/LojaServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class LojaServico extends Servico<Loja> {
    
    @PostConstruct
    public void init() {
        super.setClasse(Loja.class);
    }

    @Override
    public Loja criar() {
        return new Loja();
    }
    
    @Override
    public boolean existe(@NotNull Loja cartao) {
        TypedQuery<Loja> query = entityManager.createNamedQuery(Loja.LojaPorNome, Loja.class);
        query.setParameter(1, cartao.getNome());
        return !query.getResultList().isEmpty();
    }
    
    public void persistirLoja(Loja loja) {
        entityManager.persist(loja);
    }
    
    public Loja atualizarLoja(Loja cliente) {
        entityManager.merge(cliente);
        entityManager.flush();
        return cliente;
    }
    
    @TransactionAttribute(SUPPORTS)
    public Loja consultarPorNome( String nome) {
        return super.consultarEntidade(new Object[] {nome}, Loja.LojaPorNome);
    }
}