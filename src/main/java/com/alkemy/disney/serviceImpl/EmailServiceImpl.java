package com.alkemy.disney.serviceImpl;

import com.alkemy.disney.dto.post.EmailDto;
import com.alkemy.disney.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(EmailDto emailDTO) throws Exception {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setSubject(emailDTO.getSubject());
        helper.setText(emailDTO.getBody(), true);
        helper.setTo(emailDTO.getAddressee());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(message);
    }
}
