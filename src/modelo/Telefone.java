/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Verônica Santana
 */

@Entity
@SequenceGenerator(name = "sq_telefone", sequenceName = "sq_telefone", initialValue = 1, allocationSize = 1)
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_telefone")
    private Long id;
    
    private String numero;
    private String marca;
    
    @ManyToOne
    private Pessoa pessoa;
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
}
