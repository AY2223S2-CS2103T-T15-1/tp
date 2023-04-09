package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashSet;

import seedu.address.model.ReadOnlyReroll;
import seedu.address.model.Reroll;
import seedu.address.model.entity.Character;
import seedu.address.model.entity.Inventory;
import seedu.address.model.entity.Item;
import seedu.address.model.entity.Mob;
import seedu.address.model.entity.Name;
import seedu.address.model.entity.Stats;
import seedu.address.model.tag.Tag;

/***
 * Contains utility methods for populating {@code Reroll} with sample data.
 */
public class SampleDataUtil {

    private static Character[] sampleCharacter;
    private static Mob[] sampleMob;
    private static Item[] sampleItem;

    /** Sample Data */
    public static void getSampleEntities() {
        Tag rustyTag = new Tag("rusty");
        Tag undeadTag = new Tag("undead");
        Tag eliteTag = new Tag("elite");
        Item sword = new Item(new Name("Rusty Sword"), 3, 3, new HashSet<>(Arrays.asList(rustyTag)));
        Item bow = new Item(new Name("Rusty Bow"), 4, 3, new HashSet<>(Arrays.asList(rustyTag)));
        Item staff = new Item(new Name("Glorious Staff"), 20, 20, new HashSet<>());
        Item spellBook = new Item(new Name("Spellbook"), 5, 1, new HashSet<>());
        Inventory i1 = new Inventory(Arrays.asList(new Item[] {sword}));
        Inventory i2 = new Inventory(Arrays.asList(new Item[] {bow}));
        Inventory i3 = new Inventory(Arrays.asList(new Item[] {staff, spellBook}));
        Character c = new Character(new Name("Mike"), new Stats(3, 3, 3), 3, 2, i2, new HashSet<>());
        Mob m1 = new Mob(new Name("Skeleton Archer"), new Stats(20, 20, 20), 2,
                false, i2, new HashSet<>(Arrays.asList(undeadTag)));
        Mob m2 = new Mob(new Name("Skeleton Warrior"), new Stats(20, 20, 20), 2,
                false, i1, new HashSet<>(Arrays.asList(undeadTag)));
        Mob m3 = new Mob(new Name("Necromancer"), new Stats(300, 300, 300), 5,
                true, i3, new HashSet<>(Arrays.asList(undeadTag, eliteTag)));
        sampleCharacter = new Character[] {c};
        sampleMob = new Mob[] {m1, m2, m3};
        sampleItem = new Item[] {sword, bow, staff, spellBook};
    }

    /** Initialize Reroll with sample data */
    public static ReadOnlyReroll getSampleReroll() {
        Reroll sampleRr = new Reroll();
        getSampleEntities();
        for (Item item : sampleItem) {
            sampleRr.addEntity(item);
        }
        for (Mob mob : sampleMob) {
            sampleRr.addEntity(mob);
        }
        for (Character character : sampleCharacter) {
            sampleRr.addEntity(character);
        }

        return sampleRr;
    }
}
