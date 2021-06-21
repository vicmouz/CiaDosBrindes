/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import softwarecorporativo.entidade.Entidade;

/**
 *
 * @author victor
 * @param <T>
 */
public abstract class Bean<T extends Entidade> {

    protected T entidade;

    protected abstract boolean salvar(T entidade);

    protected abstract boolean atualizar(T entidade);

    protected abstract boolean deletar(T entidade);

    @PostConstruct
    public void init() {
        iniciarCampos();
    }

    protected abstract void iniciarCampos();

    public T getEntidade() {
        return entidade;
    }
    
    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }
    
    public void salvar() {
        try{
            boolean sucesso = salvar(entidade);
            if (sucesso) {
                adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!");
            }
        } catch (Exception ex) {
            adicionarMensagem(FacesMessage.SEVERITY_WARN, "Ocorreu um erro!");
        } finally {
            iniciarCampos();
        }
    }
    
    public void atualizar() {
        try {
            boolean sucesso = atualizar(entidade);
            if(sucesso) {
                adicionarMensagem(FacesMessage.SEVERITY_INFO, "Alteração realizada com sucesso!");
            }
        } catch (Exception ex) {
            adicionarMensagem(FacesMessage.SEVERITY_WARN, "Ocorreu um erro!");
        } finally {
            
        }
    }
    
    public void deletar() {
        try {
            boolean sucesso = deletar(entidade);
            if (sucesso) {
                adicionarMensagem(FacesMessage.SEVERITY_INFO, "Exclusão realizada com sucesso!");
            }
        } catch (Exception ex) {
            adicionarMensagem(FacesMessage.SEVERITY_WARN, "Ocorreu um erro");
        }
    }
    
    protected void adicionarMensagem(FacesMessage.Severity severity, String mensagem) {
        FacesMessage message = new FacesMessage(severity, mensagem, null);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
