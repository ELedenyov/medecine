package by.fertigi.itsm.processors;

import org.springframework.stereotype.Component;

@Component
public class EnableAuditOperation {
    private boolean enable;

    public EnableAuditOperation(boolean enable) {
        this.enable = enable;
    }

    public EnableAuditOperation() {
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
