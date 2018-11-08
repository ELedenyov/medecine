package by.fertigi.itsm.repository.domain.impl;

import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.processors.UserHolder;
import by.fertigi.itsm.repository.AbstractCrudRepository;
import by.fertigi.itsm.repository.domain.IStateRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StateRepository extends AbstractCrudRepository<State> implements IStateRepository {

    @Override
    public State findByCode(String code) {
        TypedQuery<State> query = em.createQuery("select s from states s where s.code = :code", State.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    @Override
    protected Class<State> getEntityClass() {
        return State.class;
    }


    @Override
    protected void addCreatedBy(State state) {
        state.setCreatedBy(UserHolder.getCurrentUser());
    }

    @Override
    protected void addUpdateBy(State state) {
        state.setUpdatedBy(UserHolder.getCurrentUser());
    }
}
