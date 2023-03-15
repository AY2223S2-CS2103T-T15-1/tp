package seedu.address.model.experimental;

import javafx.collections.ObservableList;
import seedu.address.model.entity.Entity;

/**
 * TBC
 * @param <T> TBC
 */
public interface ReadOnlyEntities<T extends Entity> {
    /**
     * TBC
     * @return TBC
     */
    ObservableList<T> getEntityList();
}
