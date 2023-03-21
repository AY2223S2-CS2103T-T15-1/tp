package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.experimental.model.entity.Name;
import seedu.address.experimental.model.entity.Entity;
import seedu.address.experimental.model.tag.Tag;
import seedu.address.obsolete.obsoletemodel.util.SampleDataUtil;

/**
 * A utility class to help with building Entity objects.
 */
public class EntityBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";

    private Name name;

    private Set<Tag> tags;

    /**
     * Creates a {@code EntityBuilder} with the default details.
     */
    public EntityBuilder() {
        name = new Name(DEFAULT_NAME);
        tags = new HashSet<>();
    }

    /**
     * Initializes the EntityBuilder with the data of {@code entityToCopy}.
     */
    public EntityBuilder(Entity entityToCopy) {
        name = entityToCopy.getName();
        tags = new HashSet<>(entityToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Entity} that we are building.
     */
    public EntityBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Entity} that we are building.
     */
    public EntityBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }



    public Entity build() {
        return new Entity(name, tags);
    }

}
