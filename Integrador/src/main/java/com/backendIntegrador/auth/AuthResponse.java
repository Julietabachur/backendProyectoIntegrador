package com.backendIntegrador.auth;

import com.backendIntegrador.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    String verifyToken;
    String isVerified;
    Set<Role> roles;
}