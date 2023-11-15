package br.com.escola.escola.service;

import br.com.escola.escola.model.Aluno;
import br.com.escola.escola.model.EnviarEmailIndicacao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public EnviarEmailIndicacaoComJavaMail(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void enviarPara(Aluno indicado) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(String.valueOf(indicado.getEmail()));
        message.setSubject("Bem-vindo!");
        message.setText("Bem-vindo, " + indicado.getNome() + "!");

        message.setFrom(remetente);

        emailSender.send(message);
    }

}
