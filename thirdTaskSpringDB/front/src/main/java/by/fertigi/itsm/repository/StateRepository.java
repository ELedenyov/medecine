package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
    State findByCode(String code);
}
