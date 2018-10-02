package by.fertigi.itsm.service.state;

import by.fertigi.itsm.dao.DaoState;
import by.fertigi.itsm.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stateServiceImpl")
public class StateServiceImpl implements StateService {
    private final DaoState dao;

    @Autowired
    public StateServiceImpl(@Qualifier(value = "daoStateImpl") DaoState dao) {
        this.dao = dao;
    }

    @Override
    public State getById(int id) {
        return dao.getById(id);
    }

    @Override
    public State getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public State getByCode(String code) {
        return dao.getByCode(code);
    }

    @Override
    public List<State> getAll() {
        return dao.getAll();
    }
}
