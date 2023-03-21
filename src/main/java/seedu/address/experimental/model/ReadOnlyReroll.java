package seedu.address.experimental.model;

import seedu.address.experimental.model.entity.Character;
import seedu.address.experimental.model.entity.Item;
import seedu.address.experimental.model.entity.Mob;
/***/
public interface ReadOnlyReroll {
    public ReadOnlyEntities<Item> getItems();
    public ReadOnlyEntities<Character> getCharacters();
    public ReadOnlyEntities<Mob> getMobs();
}
