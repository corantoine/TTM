package fr.initiativedeuxsevres.ttm.message.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtAuthResponse {
    private String accessToken;
    private boolean firstLogin;
}
