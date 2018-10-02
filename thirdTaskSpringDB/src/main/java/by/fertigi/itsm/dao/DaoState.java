package by.fertigi.itsm.dao;

import by.fertigi.itsm.entity.State;

import java.util.List;

public interface DaoState {
    State getById(int id);
    State getByName(String name);
    State getByCode(String code);
    List<State> getAll();
}
