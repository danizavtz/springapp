package com.example.Challenge.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int valor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategoria(Category category){
        this.category = category;
    }
}
