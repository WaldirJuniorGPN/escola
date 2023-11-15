package br.com.escola.escola.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CifradorDesenhaBcryptServerce {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String cifrarSenha(String senha){
        return this.passwordEncoder.encode(senha);
    }

    public boolean validarSenha(String senha, String senhaCifrada){
        return this.passwordEncoder.matches(senha, senhaCifrada);
    }
}
