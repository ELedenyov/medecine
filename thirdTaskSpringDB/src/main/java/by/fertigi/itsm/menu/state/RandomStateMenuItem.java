package by.fertigi.itsm.menu.state;

import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.repository.domain.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
@StateMenuItem
public class RandomStateMenuItem implements IMenuItem {

    private final IStateRepository stateRepository;

    @Autowired
    public RandomStateMenuItem(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTitle() {
        return "Print random state";
    }

    @Override
    @Transactional
    public int doAction() {
        List<State> all = stateRepository.findAll();
        int randomIndex = new Random().nextInt(all.size());
        State state = all.get(randomIndex);
        System.out.println(state);
        return 0;
    }
}
