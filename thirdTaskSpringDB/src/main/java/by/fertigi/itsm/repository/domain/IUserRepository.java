package by.fertigi.itsm.repository.domain;

import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.repository.IListRepository;

public interface IUserRepository extends IListRepository<User> {
    User authorization(String login, String password);
}
