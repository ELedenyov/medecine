package by.fertigi.itsm.menu.sale;

import by.fertigi.itsm.menu.AbstractMenu;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.TopLevelMenu;
import by.fertigi.itsm.menu.util.MenuHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@TopLevelMenu
public class SaleTopMenu extends AbstractMenu implements IMenuItem {

    @Autowired
    public SaleTopMenu(@SaleMenuItem List<IMenuItem> topLevelItems, MenuHelper menuHelper) {
        super(topLevelItems, menuHelper);
    }

    @Override
    public String getTitle() {
        return "Sales";
    }

    @Override
    public int doAction() {
        run();
        return 0;
    }
}
