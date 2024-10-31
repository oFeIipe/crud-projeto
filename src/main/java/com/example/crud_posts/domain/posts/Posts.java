package com.example.crud_posts.domain.posts;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="posts")
@Entity(name="posts")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String conteudo;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Posts(RequestPost requestPost){
        this.conteudo = requestPost.conteudo();
        this.dataCriacao = LocalDateTime.now();
    }
}
