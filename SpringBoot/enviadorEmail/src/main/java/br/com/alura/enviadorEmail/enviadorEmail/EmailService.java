package br.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void enviar(String nome, String emailDestinatario) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("email_da_conta", "password"));
			email.setSSLOnConnect(true);
			
			email.setFrom("email_q_aparece_como_remetente");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.addTo(emailDestinatario);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
