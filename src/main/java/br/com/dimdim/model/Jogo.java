package br.com.dimdim.model;

import javax.persistence.*;

//import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String genero;

    private String plataforma;

    private Double preco;
}