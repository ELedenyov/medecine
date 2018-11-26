package by.fertigi.itsm.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Salt {
    @Value("${spring.security.salt}")
    private String salt;

    public Salt() {
    }

    public Salt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
