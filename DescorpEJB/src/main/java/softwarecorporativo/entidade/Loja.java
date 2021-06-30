/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author T-Gamer
 */
@Entity
@Table(name = "TB_LOJA")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                    name = "Loja.PorNome",
                    query = "SELECT c FROM Loja c WHERE c.nome LIKE :nome ORDER BY c.nome"),

            @NamedQuery(
                    name = Loja.LojaPorNome,
                    query = "SELECT loja FROM Loja loja WHERE loja.nome = ?1")
        }
)
public class Loja extends Entidade implements Serializable{
    
    public static final String LojaPorNome = "LojaPorNome";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOJA_ID")
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @Size(max = 30)
    @Column(name = "LOJA_NOME")
    private String nome;

    @Lob
    @Size(max = 300)
    @Column(name = "LOJA_DESCRICAO")
    private String descricao;

    @NotNull(message = "CNPJ é obrigatório")
    @Column(name = "LOJA_CNPJ")
    @CNPJ
    private String cnpj;
    
    @NotNull(message = "Data inclusão é obrigatório")
    @Column(name = "LOJA_DATAINCLUSAO")
    private Date dataInclusao;
    
    @NotNull(message = "Reputação é obrigatório")
    @Column(name = "LOJA_REPUTACAO", nullable = false, length = 20) 
    @Enumerated(EnumType.STRING)
    private reputacaoLoja reputacao;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public reputacaoLoja getReputacao() {
        return reputacao;
    }

    public void setReputacao(reputacaoLoja reputacao) {
        this.reputacao = reputacao;
    }
    
    
}
