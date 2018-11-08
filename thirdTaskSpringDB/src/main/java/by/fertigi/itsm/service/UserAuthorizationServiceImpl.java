package by.fertigi.itsm.service;

import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.processors.UserHolder;
import by.fertigi.itsm.repository.domain.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Scanner;

@Service
public class UserAuthorizationServiceImpl implements IAuthorizationService {
    private IUserRepository userRepository;
    private ICryptoService cryptoService;
    private UserHolder userHolder;

    @Autowired
    public UserAuthorizationServiceImpl(IUserRepository userRepository, ICryptoService cryptoService, UserHolder userHolder) {
        this.userRepository = userRepository;
        this.cryptoService = cryptoService;
        this.userHolder = userHolder;
    }

    @Override
    public boolean authorization() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login: ");
        String login = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = enterPassword();

        String hashPassword = cryptoService.doAction(password);
        User user = null;
        boolean success = true;
        try {
            user = userRepository.authorization(login, hashPassword);
            userHolder.login(user);
        }catch (NoResultException e) {
            success = false;
        }
        return success;
    }

    private String enterPassword(){
        return System.console()!= null ? String.valueOf(System.console().readPassword()) : new Scanner(System.in).nextLine();
    }
}
