package com.example.crud_posts.domain.posts;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RequestPost(
        String id,

        @NotBlank String conteudo,

        LocalDateTime dataCriacao) {
}
