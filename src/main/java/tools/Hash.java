package tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



public class Hash {

  public static PasswordEncoder hash() {
    String idForEncode = "bcrypt";
    Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
    encoders.put(idForEncode, new BCryptPasswordEncoder());
    PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

    return  passwordEncoder;
  }
}
