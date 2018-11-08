package by.fertigi.itsm.menu.state;

import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.repository.domain.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StateMenuItem
public class StateListMenuItem implements IMenuItem {

    private final IStateRepository stateRepository;

    @Autowired
    public StateListMenuItem(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTitle() {
        return "Print state list";
    }

    @Override
    public int doAction() {
        stateRepository.findAll().forEach(System.out::println);
        return 0;
    }
}
