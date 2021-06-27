/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.entidade;

import softwarecorporativo.validador.ValidaPais;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author marcosbrasileiro
 */
@Embeddable
public class EnderecoCliente extends Entidade implements Serializable {

    public static final String EnderecoPorCep = "EnderecoPorCep";

    @NotNull(message = "Nome da rua é obrigatório")
    @Size(max = 100)
    @Column(name = "ENDERECO_NOME")
    private String nome;

    @NotBlank(message = "Número é obrigatório")
    @Size(max = 10)
    @Column(name = "ENDERECO_NUMERO")
    private String numero;

    @Size(max = 200)
    @Column(name = "ENDERECO_COMPLEMENTO")
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 20)
    @Column(name = "ENDERECO_BAIRRO")
    private String bairro;

    @NotBlank(message = "Cidade é obrigatório")
    @Size(max = 40)
    @Column(name = "ENDERECO_CIDADE")
    private String cidade;

    @NotBlank(message = "CEP é obrigatório")
    @Size(max = 20)
    @Column(name = "ENDERECO_CEP")
    protected String cep;

    @NotNull(message = "Estado é obrigatório")
    @Size(max = 30)
    @Column(name = "ENDERECO_ESTADO")
    protected String estado;

    @NotNull(message = "País é obrigatório")
    @ValidaPais(message = "País inválido")
    @Size(max = 2)
    @Column(name = "ENDERECO_PAIS")
    protected String pais;

    public boolean possui(String nome) {
        return nome.contains(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
