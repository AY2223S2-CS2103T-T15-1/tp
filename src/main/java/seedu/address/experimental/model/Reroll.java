package seedu.address.experimental.model;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.obsolete.obsoletemodel.entity.Character;
import seedu.address.obsolete.obsoletemodel.entity.Entity;
import seedu.address.obsolete.obsoletemodel.entity.Item;
import seedu.address.obsolete.obsoletemodel.entity.Mob;

// Driver function.

/**
 * Reroll...
 */
public class Reroll implements ReadOnlyReroll {
    private final RerollCharacters characters;
    private final RerollItems items;
    private final RerollMobs mobs;
    private final RerollAllEntities entities;

    {
        characters = new RerollCharacters();
        items = new RerollItems();
        mobs = new RerollMobs();
        entities = new RerollAllEntities();
    }

    public Reroll() {}

    /**
     * Create Reroll from existing copy
     * @param toBeCopied
     */
    public Reroll(ReadOnlyReroll toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Reset data to newData
     * @param newData
     */
    public void resetData(ReadOnlyReroll newData) {
        requireNonNull(newData);

        characters.resetData(newData.getCharacters());
        items.resetData(newData.getItems());
        mobs.resetData(newData.getMobs());

        // Initialize all entities
        entities.addAll(characters);
        entities.addAll(items);
        entities.addAll(mobs);

    }

    @Override
    public ReadOnlyEntities<Item> getItems() {
        return items;
    }

    @Override
    public ReadOnlyEntities<Character> getCharacters() {
        return characters;
    }

    @Override
    public ReadOnlyEntities<Mob> getMobs() {
        return mobs;
    }

    // Entity level operations ===============

    /**
     * Has entity
     * @param e
     * @return
     */
    public boolean hasEntity(Entity e) {
        return entities.hasEntity(e);
    }

    /**
     * Add Item
     */
    public void addItem(Item item) {
        items.addEntity(item);
        entities.addEntity(item);
    }

    /**
     * Add Character
     */
    public void addCharacter(Character character) {
        characters.addEntity(character);
        entities.addEntity(character);
    }

    /**
     * Add Mob
     */
    public void addMob(Mob mob) {
        mobs.addEntity(mob);
        entities.addEntity(mob);
    }

    /**
     * Set Item
     */
    public void setItem(Item target, Item edited) {
        items.setEntity(target, edited);
        entities.setEntity(target, edited);
    }

    /**
     * Set character
     */
    public void setCharacter(Character target, Character edited) {
        characters.setEntity(target, edited);
        entities.setEntity(target, edited);
    }

    /**
     * Set Mob
     */
    public void setMob(Mob target, Mob edited) {
        mobs.setEntity(target, edited);
        entities.setEntity(target, edited);
    }

    /**
     * Delete item
     */
    public void deleteItem(Item key) {
        items.deleteEntity(key);
        entities.deleteEntity(key);
    }

    /**
     * Delete character
     */
    public void deleteCharacter(Character key) {
        characters.deleteEntity(key);
        entities.deleteEntity(key);
    }

    /**
     * Delete Mob
     */
    public void deleteMob(Mob key) {
        mobs.deleteEntity(key);
        entities.deleteEntity(key);
    }

    // Misc ====================

    /**
     * Return list for the all entities in
     * @return
     */
    public ObservableList<Entity> getAllList() {
        return entities.getEntityList();
    }

    public ObservableList<? extends Entity> getCharacterList() {
        // not slap at all
        return characters.getEntityList();
    }

    public ObservableList<? extends Entity> getItemList() {
        return items.getEntityList();
    }

    public ObservableList<? extends Entity> getMobList() {
        return mobs.getEntityList();
    }


    @Override
    public String toString() {
        return "Characters:" + characters.toString() + "\nItems" + items.toString() + "\nMobs" + mobs.toString();
    }
}
