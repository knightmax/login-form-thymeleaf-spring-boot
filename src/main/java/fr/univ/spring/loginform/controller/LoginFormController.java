package fr.univ.spring.loginform.controller;

import fr.univ.spring.loginform.model.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class LoginFormController {

    @GetMapping(value = {"/", "/index"})
    public String home() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String registration(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            // Des erreurs de validation ont été détectées, afficher les messages d'erreur appropriés
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            model.addAttribute("errors", errorMessages);
            return "login";
        }

        // Les validations ont réussi, afficher le message de confirmation de création de compte
        String encryptedPassword = encode(loginForm.getEmail(), loginForm.getPassword());
        model.addAttribute("confirmationMessage", "Compte créé avec succès ! Adresse email : " + loginForm.getEmail() + ", Mot de passe chiffré : " + encryptedPassword);

        return "welcome";
    }

    public String encode(String login, String password) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(login.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(rawHmac);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMAC : " + e.getMessage());
        }
    }
}
