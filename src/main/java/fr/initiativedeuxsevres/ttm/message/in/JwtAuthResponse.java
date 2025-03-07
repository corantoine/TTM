package fr.initiativedeuxsevres.ttm.message.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtAuthResponse {
    String accessToken;
}
