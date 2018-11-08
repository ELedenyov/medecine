package by.fertigi.itsm.repository.domain;


import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.repository.ICrudRepository;

public interface IStateRepository extends ICrudRepository<State> {
    State findByCode(String code);
}
