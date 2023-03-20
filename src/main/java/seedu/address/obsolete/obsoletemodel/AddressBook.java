package seedu.address.obsolete.obsoletemodel;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.obsolete.obsoletemodel.entity.UniqueEntityList;
import seedu.address.obsolete.obsoletemodel.entity.Entity;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniqueEntityList entities;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */ {
        entities = new UniqueEntityList();
    }

    public AddressBook() {
    }

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code entities}.
     * {@code entities} must not contain duplicate entities.
     */
    public void setEntities(List<Entity> entities) {
        this.entities.setPersons(entities);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setEntities(newData.getEntityList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasEntity(Entity entity) {
        requireNonNull(entity);
        return entities.contains(entity);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addEntity(Entity p) {
        entities.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setEntity(Entity target, Entity editedEntity) {
        requireNonNull(editedEntity);

        entities.setPerson(target, editedEntity);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeEntity(Entity key) {
        entities.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return entities.asUnmodifiableObservableList().size() + " entities";
        // TODO: refine later
    }

    @Override
    public ObservableList<Entity> getEntityList() {
        return entities.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && entities.equals(((AddressBook) other).entities));
    }

    @Override
    public int hashCode() {
        return entities.hashCode();
    }
}
