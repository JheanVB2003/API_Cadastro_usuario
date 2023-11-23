package br.com.cadastro.usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "usuario_user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //tipo UUID para gerar ID aleatoriamente
    @Column(name = "id")
    private UUID  id;
    @NotBlank(message = "O Nome é obrigatório!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    @NotBlank(message = "O CPF é obrigatório!")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String CPF;
    @NotBlank(message = "O EMAIL é obrigatório!")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @NotBlank(message = "A senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT" , nullable = false)
    private String senha;
    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;

}
