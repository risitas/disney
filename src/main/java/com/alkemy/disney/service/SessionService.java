package com.alkemy.disney.service;

import com.alkemy.disney.security.model.dto.SessionDTO;
import com.alkemy.disney.security.model.dto.TokenDTO;

public interface SessionService {
    TokenDTO login(SessionDTO dto) throws Exception;
}
