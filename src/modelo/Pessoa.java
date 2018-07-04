/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Verônica Santana
 */

@Entity
@SequenceGenerator(name = "sq_pessoa", sequenceName = "sq_pessoa", initialValue = 1, allocationSize = 1)
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pessoa")
    private Long id;
    private String nome;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_nascimento")
    private Date nascimento;
    
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa")
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    
    
}
