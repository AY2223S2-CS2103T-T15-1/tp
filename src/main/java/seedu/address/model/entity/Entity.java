package seedu.address.model.entity;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.*;

import javafx.util.Pair;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book. Guarantees: details are present and not null, field values are validated,
 * immutable.
 */
public abstract class Entity {

    // Identity fields
    private final Name name;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Entity(Name name, Set<Tag> tags) {
        requireAllNonNull(name, tags);
        this.name = name;
        this.tags.addAll(tags);
    }

    /**
     * Initial declaration of entity
     * @param name name of the entity
     */
    public Entity(Name name) {
        requireAllNonNull(name);
        this.name = name;
    }

    public abstract List<Pair<String, String>> getFields();

    public Name getName() {
        return name;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException} if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name. This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Entity otherEntity) {
        if (otherEntity == this) {
            return true;
        }

        return otherEntity != null
            && otherEntity.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields. This defines a stronger notion of equality
     * between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Entity)) {
            return false;
        }

        Entity otherEntity = (Entity) other;
        return otherEntity.getName().equals(getName())
            && otherEntity.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

    public boolean isSameEntity(Entity other) {
        return false;
    }
}
