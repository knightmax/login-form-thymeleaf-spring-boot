package fr.univ.spring.loginform.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginForm {
    @NotEmpty(message = "L'adresse email ne peut pas être vide")
    @Email(message = "L'adresse email doit être valide")
    private String email;

    @NotEmpty(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 8, max = 15, message = "Le mot de passe doit avoir entre 8 et 15 caractères")
    @Pattern(regexp = ".*\\d.*\\d.*", message = "Le mot de passe doit contenir au moins 2 chiffres")
    private String password;

    @NotEmpty(message = "Le nom ne peut pas être vide")
    @Size(min = 2, message = "Le nom doit avoir au moins 2 caractères")
    @Pattern(regexp = "[a-zA-Z]+", message = "Le nom ne peut contenir que des lettres")
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
