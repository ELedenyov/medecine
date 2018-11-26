package by.fertigi.itsm.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnableAuditOperation {
    @Value("${spring.auditoperation.enable}")
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
