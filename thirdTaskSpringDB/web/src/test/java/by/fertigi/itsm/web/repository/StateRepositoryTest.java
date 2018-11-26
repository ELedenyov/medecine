package by.fertigi.itsm.web.repository;

import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Ignore
public class StateRepositoryTest {
    @Autowired
    private StateRepository stateRepository;

    @Test(expected = Exception.class)
    public void testUniqueCodeConstraint() {
        User user = new User();
        Date date = new Date();
        stateRepository.save(new State(null, "AL", "Alabama", user, user, date, date));
    }

    @Test
    public void testSave() {
        User user = new User();
        Date date = new Date();
        stateRepository.save(new State(null, "AR", "Arkansas", user, user, date, date));
    }

}