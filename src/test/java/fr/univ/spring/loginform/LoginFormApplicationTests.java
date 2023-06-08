package fr.univ.spring.loginform;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LoginFormApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndex() throws Exception {
        mockMvc.perform(get("/index"))
              .andExpect(status().isOk())
              .andExpect(view().name("index"))
              .andExpect(content().string(containsString("<h1>Hello World</h1>")));
    }

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(get("/login"))
              .andExpect(status().isOk())
              .andExpect(view().name("login"))
              .andExpect(model().attributeExists("loginForm"))
              .andExpect(content().string(containsString("<h1>Login Form</h1>")))
              .andExpect(content().string(containsString("id=\"email\"")))
              .andExpect(content().string(containsString("id=\"password\"")))
              .andExpect(content().string(containsString("id=\"name\"")));
    }

    @Test
    void testLoginWithErrors() throws Exception {
        this.mockMvc.perform(post("/login")
                    .param("email", "test@test.fr")
                    .param("password", "password")
                    .param("name", "Max"))
              .andExpect(model().attributeExists("errors"));
    }

    @Test
    void testLoginOk() throws Exception {
        String password = "azerty123";
        String mail = "test@test.fr";
        this.mockMvc.perform(post("/login")
                    .param("email", mail)
                    .param("password", password)
                    .param("name", "Max"))
              .andExpect(status().isOk())
              .andExpect(content().string(not(containsString(password))))
              .andExpect(content().string(containsString(mail)));
    }
}
