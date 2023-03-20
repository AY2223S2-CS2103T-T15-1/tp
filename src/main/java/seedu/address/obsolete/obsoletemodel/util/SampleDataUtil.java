package seedu.address.obsolete.obsoletemodel.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.obsolete.obsoletemodel.AddressBook;
import seedu.address.obsolete.obsoletemodel.ReadOnlyAddressBook;
import seedu.address.obsolete.obsoletemodel.entity.Entity;
import seedu.address.obsolete.obsoletemodel.entity.Name;
import seedu.address.obsolete.obsoletemodel.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Entity[] getSamplePersons() {
        return new Entity[]{
                new Entity(new Name("Alex Yeoh"),
                        getTagSet("friends")),
                new Entity(new Name("Bernice Yu"),
                        getTagSet("colleagues", "friends")),
                new Entity(new Name("Charlotte Oliveiro"),
                        getTagSet("neighbours")),
                new Entity(new Name("David Li"),
                        getTagSet("family")),
                new Entity(new Name("Irfan Ibrahim"),
                        getTagSet("classmates")),
                new Entity(new Name("Roy Balakrishnan"),
                        getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Entity sampleEntity : getSamplePersons()) {
            sampleAb.addEntity(sampleEntity);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
