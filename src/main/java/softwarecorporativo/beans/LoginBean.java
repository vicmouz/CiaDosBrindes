/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import softwarecorporativo.entidade.Administrador;
import softwarecorporativo.entidade.ClienteUsuario;

/**
 *
 * @author victor
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @Size(max = 40)
    @Email
    private String email;
    @CPF
    private String cpf;

    ClienteBean clienteBean = new ClienteBean();
    private final List<ClienteUsuario> clientes = clienteBean.getClientes();
    
    AdministradorBean administradorBean = new AdministradorBean();
    private final List<Administrador> adms = administradorBean.getAdministradores();
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF String cpf) {
        this.cpf = cpf;
    }

    public LoginBean() {
    }
    
    public boolean isValidCliente(@Email String email, @CPF String cpf) {
        
        return false;
    }    
}
