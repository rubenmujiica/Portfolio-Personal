package com.portfolio.my_portfolio_backend_ruben.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoDto {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String firstName;
    @NotBlank(message = "El apellido no puede estar vacío")
    private String lastName;
    @NotBlank(message = "El título no puede estar vacío")
    private String title;
    @NotBlank(message = "La descripción del perfil no puede estar vacía")
    private String profileDescription;
    @NotBlank(message = "La imagen no puede estar vacía")
    private String profileImageUrl;
    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos.")
    private Integer yearsOfExperience;
    @Email(message = "El email no es válido")
    private String email;
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String phone;
    @URL(message = "Linkedin es una red obligatoria")
    private String linkedinUrl;
    @URL(message = "Github es una red obligatoria")
    private String githubUrl;
}
