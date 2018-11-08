package by.fertigi.itsm.repository.domain.impl;

import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.repository.AbstractListRepository;
import by.fertigi.itsm.repository.domain.IUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class UserRepository extends AbstractListRepository<User> implements IUserRepository {
    @Override
    public User authorization(String login, String password) {
        TypedQuery<User> query = em.createQuery("select u from user u where u.login = :login and u.password = :password", User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
