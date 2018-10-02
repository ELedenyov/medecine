package by.fertigi.itsm.service.state;

import by.fertigi.itsm.entity.State;

import java.util.List;

public interface StateService {
    State getById(int id);
    State getByName(String name);
    State getByCode(String code);
    List<State> getAll();
}
