package by.fertigi.itsm.service;

import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.repository.UserRepository;
import by.fertigi.itsm.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class UserAuthorizationServiceImpl implements IAuthorizationService {
    private UserRepository userRepository;
    private ICryptoService cryptoService;
    private UserHolder userHolder;

    @Autowired
    public UserAuthorizationServiceImpl(UserRepository userRepository, ICryptoService cryptoService, UserHolder userHolder) {
        this.userRepository = userRepository;
        this.cryptoService = cryptoService;
        this.userHolder = userHolder;
    }

    @Override
    public boolean authorization(String login, String password) {

        String hashPassword = cryptoService.doAction(password);
        User user = null;
        boolean success = true;
        try {
            user = userRepository.findByLogin(login);
            if(user.getPassword().equals(hashPassword)) {
                userHolder.login(user);
            } else {
                success = false;
            }
        }catch (NoResultException e) {
            success = false;
        }
        return success;
    }
}
