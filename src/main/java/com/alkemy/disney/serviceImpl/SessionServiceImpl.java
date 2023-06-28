package com.alkemy.disney.serviceImpl;

import com.alkemy.disney.security.model.UserDetailsImpl;
import com.alkemy.disney.security.model.dto.SessionDTO;
import com.alkemy.disney.security.model.dto.TokenDTO;
import com.alkemy.disney.security.service.JwtService;
import com.alkemy.disney.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SessionServiceImpl implements SessionService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public TokenDTO login(SessionDTO sessionDTO) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sessionDTO.getEmail(),
                        sessionDTO.getPassword())
        );

        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        return new TokenDTO(jwtToken);
    }
}
