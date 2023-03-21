package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.experimental.model.ReadOnlyEntities;
import seedu.address.experimental.model.entity.Name;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.UiSwitchMode;
import seedu.address.experimental.model.entity.Entity;
import seedu.address.experimental.model.tag.Tag;

import java.util.Optional;
import java.util.Set;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_SUCCESS = "Entered Edit Mode";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Deletes the person identified by the index number used in the displayed person list.\n"
        + "Parameters: CLASSIFICATION (char, mob or item) NAME (name of entity)\n"
        + "Example: " + COMMAND_WORD + " item short dagger";

    private final String toEditName;
    private final String toEditClassification;

    /**
     * Creates an EditCommand to enter Edit Mode for the specified {@code Entity}
     */
    public EditCommand(String toEditClassification, String toEditName) {
        this.toEditClassification = toEditClassification;
        this.toEditName = toEditName;
    }

    @Override
    public CommandResult execute(seedu.address.experimental.model.Model model) throws CommandException {
        requireNonNull(model);
        ReadOnlyEntities rerollEntities;
        switch (toEditClassification) {
        case "char":
            rerollEntities = model.getReroll().getCharacters();
            break;
        case "mob":
            rerollEntities = model.getReroll().getMobs();
            break;
        case "item":
            rerollEntities = model.getReroll().getItems();
            break;
        default:
            throw new CommandException("Invalid Classification!");
        }

        for (Object entity : rerollEntities.getEntityList()) {
            if (((Entity) entity).getName().fullName.equals(toEditName)) {
                model.setCurrentSelectedEntity((Entity) entity);
                return new CommandResult(MESSAGE_SUCCESS, false, false, UiSwitchMode.VIEW);
            }
        }

        throw new CommandException(String.format("No such entity in %s!", toEditClassification));
    }

    public class EditEntityDescriptor {
        private Name name;
        private Set<Tag> tags;

        public EditEntityDescriptor() {}

        public EditEntityDescriptor(EditEntityDescriptor toCopy) {
            setName(toCopy.name);
            setTags(toCopy.tags);
        }

        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name,tags);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public Optional<Set<Tag>> getTags() {
            return Optional.ofNullable(tags);
        }

        public void setTags(Set<Tag> tags) {
            this.tags = tags;
        }
    }
}

