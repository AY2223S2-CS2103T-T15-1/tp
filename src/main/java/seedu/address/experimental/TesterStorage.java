package seedu.address.experimental;

import java.io.IOException;
import java.nio.file.Paths;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.experimental.model.ReadOnlyReroll;
import seedu.address.experimental.model.UserPrefs;
import seedu.address.experimental.model.util.SampleDataUtil;
import seedu.address.experimental.storage.JsonRerollStorage;
import seedu.address.experimental.storage.JsonUserPrefsStorage;
import seedu.address.experimental.storage.RerollStorage;
import seedu.address.experimental.storage.Storage;
import seedu.address.experimental.storage.StorageManager;
import seedu.address.experimental.storage.UserPrefsStorage;

// This is tldr of the initialization for storage.

/***/
public class TesterStorage {
    /***/
    public static void main(String[] args) {
        // Instead of hard coded filepath, MainApp uses Config to get this.
        UserPrefsStorage ups = new JsonUserPrefsStorage(Paths.get("preferences.json"));
        // Instead of explicit object creation, MainApp uses some function to get UserPrefs
        UserPrefs up = new UserPrefs();
        // Creates RerollStorage using UserPrefs filePath
        RerollStorage rrs = new JsonRerollStorage(up.getAddressBookFilePath());
        // Creates Storage!
        Storage storage = new StorageManager(rrs, ups);
        // Quick check that storage is working as expected.
        // Creates a ReadOnlyReroll using SampleDataUtil (default behaviour of AddressBook) and save it
        try {
            // Expects to create a new reroll.json with the sample data
            storage.saveReroll(SampleDataUtil.getSampleReroll());
        } catch (IOException e) {
            System.out.println("error");
        }

        // Check that readReroll is consistent
        try {
            // read is only used at the start of the program.
            ReadOnlyReroll rr = storage.readReroll().get();
            System.out.println("Characters: " + rr.getCharacters().getEntityList());
            System.out.println("Mobs: " + rr.getMobs().getEntityList());
            System.out.println("Items: " + rr.getItems().getEntityList());
        } catch (DataConversionException e) {
            System.out.println("May this never happen");
        } catch (IOException e) {
            System.out.println("error");
        }

    }
}
