package com.alkemy.disney.service;

import com.alkemy.disney.dto.post.EmailDto;

public interface EmailService {

    void sendEmail(EmailDto emailDTO) throws Exception;
}
