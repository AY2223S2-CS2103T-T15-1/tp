package seedu.address.experimental.model;

import seedu.address.obsolete.obsoletemodel.entity.Character;
import seedu.address.obsolete.obsoletemodel.entity.Item;
import seedu.address.obsolete.obsoletemodel.entity.Mob;
/***/
public interface ReadOnlyReroll {
    public ReadOnlyEntities<Item> getItems();
    public ReadOnlyEntities<Character> getCharacters();
    public ReadOnlyEntities<Mob> getMobs();
}
