package br.com.dimdim.model;

import javax.persistence.*;
//import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String autor;

    private String editora;

    private Double preco;
}