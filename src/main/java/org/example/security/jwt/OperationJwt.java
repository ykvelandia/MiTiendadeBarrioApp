package org.example.security.jwt;

import org.example.dto.TokenDto;
import org.example.model.user.User;

public interface OperationJwt {
    TokenDto generateTokenDto(User user);
}
