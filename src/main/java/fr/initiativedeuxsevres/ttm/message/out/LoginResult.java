package fr.initiativedeuxsevres.ttm.message.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {
    private String token;
    private boolean firstLogin;

}
