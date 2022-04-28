package com.juandev.spring_thymeleaf;

import com.juandev.spring_thymeleaf.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    @NotNull
    @NotEmpty(message = "Informe o nome do Livro")
    private String name;

    private Long authorId;
}
