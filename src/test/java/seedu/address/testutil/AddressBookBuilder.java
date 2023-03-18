package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.entity.Entity;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withEntity("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Entity} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withEntity(Entity entity) {
        addressBook.addEntity(entity);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
