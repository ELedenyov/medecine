package by.fertigi.itsm.service;

import by.fertigi.itsm.util.Salt;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements ICryptoService {
    private Salt salt;

    @Autowired
    public EncryptionServiceImpl(Salt salt) {
        this.salt = salt;
    }

    @Override
    public String doAction(String password) {
        return BCrypt.hashpw(password, salt.getSalt());
    }
}
