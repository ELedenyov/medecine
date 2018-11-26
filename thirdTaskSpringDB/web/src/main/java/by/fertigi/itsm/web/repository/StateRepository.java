package by.fertigi.itsm.web.repository;

import by.fertigi.itsm.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/state")
public interface StateRepository extends JpaRepository<State, Integer> {

}
