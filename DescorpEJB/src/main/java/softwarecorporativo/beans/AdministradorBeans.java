/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;
import java.io.Serializable;
import softwarecorporativo.entidade.Administrador;
import softwarecorporativo.servico.AdministradorServico;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import javax.inject.Named;
import javax.inject.Inject;
/**
 *
 * @author marcosbrasil98
 */
@RequestScoped
@Named(value = "AdministradorBean")
public class AdministradorBeans extends Beans<Administrador> implements Serializable{

    @Inject
    private AdministradorServico administradorServico;

private List<Administrador> administradores;
    @Override
    protected boolean salvar(Administrador entidade) {
       administradorServico.persistirAdministrador(entidade);
       return true;
    }

    @Override
    protected boolean atualizar(Administrador entidade) {
       administradorServico.atualizarAdministrador(entidade);
       return true;
    }

    @Override
    protected boolean deletar(Administrador entidade) {
    administradorServico.deletar(entidade);
    return true;
    }

    @Override
    protected void iniciarCampos() {
        setEntidade(administradorServico.criar());
    }

    

    public List<Administrador> getAdministradores() {
        if (administradores == null) {
            administradores = administradorServico.getAdms();
        }
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }
    
    
    
}