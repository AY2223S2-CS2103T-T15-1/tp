package seedu.address.experimental.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.entity.Character;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.Item;
import seedu.address.model.entity.Mob;

/**
 * Represents the in-memory model of the Reroll data.
 */
public class ModelManager implements Model {

    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private static final Predicate<Entity> PREDICATE_IS_CHARACTER = entity -> entity instanceof Character;
    private static final Predicate<Entity> PREDICATE_IS_MOB = entity -> entity instanceof Mob;
    private static final Predicate<Entity> PREDICATE_IS_ITEM = entity -> entity instanceof Item;

    private final Reroll reroll;
    private final UserPrefs userPrefs;
    private final FilteredList<Entity> filteredAllEntities;
    // Placeholder for the active list.
    private FilteredList<Entity> filteredActive;
    private Entity active = null;

    private Entity currentSelectedEntity;

    /**
     * Initializes a ModelManager with the given reroll and userPrefs.
     */

    public ModelManager(ReadOnlyReroll reroll, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(reroll, userPrefs);

        logger.fine("Initializing with Reroll: " + reroll + " and user prefs " + userPrefs);

        this.reroll = new Reroll(reroll);
        this.userPrefs = new UserPrefs(userPrefs);
        this.filteredAllEntities = new FilteredList<>(this.reroll.getAllList());
        // By default, the active list is all entities.
        this.filteredActive = this.filteredAllEntities;
    }

    public ModelManager() {
        this(new Reroll(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getRerollFilePath() {
        return userPrefs.getRerollFilePath();
    }

    @Override
    public void setRerollFilePath(Path rerollFilePath) {
        requireNonNull(rerollFilePath);
        userPrefs.setRerollFilePath(rerollFilePath);
    }

    //=====================================Rerollllll==============================

    @Override
    public void setReroll(ReadOnlyReroll reroll) {
        this.reroll.resetData(reroll);
    }

    @Override
    public ReadOnlyReroll getReroll() {
        return reroll;
    }

    @Override
    public boolean hasEntity(Entity entity) {
        requireNonNull(entity);
        return reroll.hasEntity(entity);
    }

    @Override
    public void addEntity(Entity entity) {
        requireNonNull(entity);
        reroll.addEntity(entity);
        updateFilteredEntityList(PREDICATE_SHOW_ALL_ENTITIES);
    }

    @Override
    public void deleteEntity(Entity key) {
        requireNonNull(key);
        reroll.deleteEntity(key);
    }

    @Override
    public void setEntity(Entity target, Entity edited) {
        requireAllNonNull(target, edited);
        if (!target.getClass().equals(edited.getClass())) {
            return; // throw error.
        }
        reroll.setEntity(target, edited);
    }

    // =========== List operations

    @Override
    public void listItems() {
        updateFilteredEntityList(PREDICATE_IS_ITEM);
    }

    @Override
    public void listCharacters() {
        updateFilteredEntityList(PREDICATE_IS_CHARACTER);
    }

    @Override
    public void listMobs() {
        updateFilteredEntityList(PREDICATE_IS_MOB);
    }

    //=========== Filtered Entity List Accessors =============================================================

    @Override
    public ObservableList<Entity> getFilteredEntityList() {
        return filteredActive;
    }

    @Override
    public void updateFilteredEntityList(Predicate<Entity> predicate) {
        requireNonNull(predicate);
        filteredActive.setPredicate(predicate);
    }

    // Reset
    @Override
    public void resetFilteredEntityList() {
        updateFilteredEntityList(PREDICATE_SHOW_ALL_ENTITIES);
    }

    //=========== Edit Mode =============================================================

    @Override
    public Entity getCurrentSelectedEntity() {
        return currentSelectedEntity;
    }

    @Override
    public void setCurrentSelectedEntity(Entity newSelection) {
        currentSelectedEntity = newSelection;
    }
}
