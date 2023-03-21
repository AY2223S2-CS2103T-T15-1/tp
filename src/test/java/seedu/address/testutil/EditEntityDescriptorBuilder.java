package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditEntityDescriptor;
import seedu.address.experimental.model.entity.Name;
import seedu.address.experimental.model.entity.Entity;
import seedu.address.experimental.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditEntityDescriptorBuilder {

    private EditEntityDescriptor descriptor;

    public EditEntityDescriptorBuilder() {
        descriptor = null;//new EditEntityDescriptor();
    }

    public EditEntityDescriptorBuilder(EditEntityDescriptor descriptor) {
        this.descriptor = null; //new EditEntityDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditEntityDescriptorBuilder(Entity entity) {
        descriptor = null; //new EditEntityDescriptor();
        descriptor.setName(entity.getName());
        descriptor.setTags(entity.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditEntityDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditEntityDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditEntityDescriptor build() {
        return descriptor;
    }
}
