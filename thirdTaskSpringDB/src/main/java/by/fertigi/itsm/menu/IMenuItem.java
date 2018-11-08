package by.fertigi.itsm.menu;

public interface IMenuItem {
    Integer EXIT_CODE = -1;

    String getTitle();

    int doAction();

    default int priority() {
        return 0;
    }
}
