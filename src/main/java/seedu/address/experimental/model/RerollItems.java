package seedu.address.experimental.model;

import seedu.address.experimental.model.entity.Item;


/**
 * Abstraction of all items
 */
public class RerollItems extends RerollEntities<Item> {

    // For convenience
    private final UniqueEntityList items = entities;

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof RerollItems
                && items.equals(((RerollItems) other).items));
    }

}
