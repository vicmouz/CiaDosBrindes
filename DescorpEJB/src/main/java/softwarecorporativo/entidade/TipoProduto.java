/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarecorporativo.entidade;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marcosbrasil98
 */
@Entity
@Table(name = "TB_TIPOPRODUTO")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                    name = TipoProduto.TipoProdutoPorNome,
                    query = "SELECT tp FROM TipoProduto tp WHERE tp.nome = ?1")

        }
)

public class TipoProduto extends Entidade implements Serializable {

    public static final String TipoProdutoPorNome = "TipoProdutoPorNome";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPOPRODUTO_ID")
    private Long id;

    @NotNull(message = "Tipo do produto é obrigatório")
    @Size(min = 1, max = 50)
    @Column(name = "TIPOPRODUTO_NOME")
    private String nome;

    public boolean possui(String nome) {
        return nome.contains(nome);
    }

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

}
