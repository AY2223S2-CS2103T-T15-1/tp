package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.obsolete.obsoletemodel.entity.Entity;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class EntityCard extends UiPart<Region> {

    private static final String FXML = "EntityListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX. As a consequence, UI
     * elements' variable names cannot be set to such keywords or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Entity entity;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label classification;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCard} with the given {@code Person} and index to display.
     */
    public EntityCard(Entity entity, int displayedIndex) {
        super(FXML);
        this.entity = entity;
        id.setText(displayedIndex + ". ");
        name.setText(entity.getName().fullName);
        classification.setText(entity.getClass().getSimpleName());
        entity.getTags().stream()
            .sorted(Comparator.comparing(tag -> tag.tagName))
            .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EntityCard)) {
            return false;
        }

        // state check
        EntityCard card = (EntityCard) other;
        return id.getText().equals(card.id.getText())
            && entity.equals(card.entity);
    }
}
