package tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class HASH {



    public static PasswordEncoder hash(){
        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

        return  passwordEncoder;
    }
}
