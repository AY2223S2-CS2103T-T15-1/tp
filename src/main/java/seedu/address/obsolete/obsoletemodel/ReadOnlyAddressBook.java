package seedu.address.obsolete.obsoletemodel;

import javafx.collections.ObservableList;
import seedu.address.experimental.model.entity.Entity;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Entity> getEntityList();

}
