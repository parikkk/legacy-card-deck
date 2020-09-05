package cc.cards;

import java.util.logging.Logger;

public interface BaseEntity {
    default Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }
}
