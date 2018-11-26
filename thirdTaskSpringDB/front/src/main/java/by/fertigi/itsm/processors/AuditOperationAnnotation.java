package by.fertigi.itsm.processors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AuditOperationAnnotation {
    String operation();
}
