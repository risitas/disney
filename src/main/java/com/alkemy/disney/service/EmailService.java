package com.alkemy.disney.service;

import com.alkemy.disney.dto.post.EmailPostDto;

public interface EmailService {

    void sendEmail(EmailPostDto emailPostDto) throws Exception;
}
