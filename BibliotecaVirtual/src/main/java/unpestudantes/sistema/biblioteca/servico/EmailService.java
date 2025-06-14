package unpestudantes.sistema.biblioteca.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void enviarCodigoVerificacao(String to, String codigo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Código de verificação - Biblioteca UnP");
        message.setText("Seu código de verificação é: " + codigo);
        mailSender.send(message);
    }

    public void enviarLembreteDevolucao(String to, String nomeLivro, String dataDevolucao) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Lembrete de devolução - Biblioteca UnP");
        message.setText("Lembrete: o livro \"" + nomeLivro + "\" deve ser devolvido até " + dataDevolucao + ".");
        mailSender.send(message);
    }
}