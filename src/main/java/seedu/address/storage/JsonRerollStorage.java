package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyReroll;

/**
 * A class to access Reroll data stored as a Json file on the hard disk.
 */
public class JsonRerollStorage implements RerollStorage {
    private static final Logger logger = LogsCenter.getLogger(JsonRerollStorage.class);

    private Path filePath;

    /**
     * Initialize with given file path.
     */
    public JsonRerollStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getRerollFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyReroll> readReroll() throws DataConversionException {
        return readReroll(filePath);
    }

    @Override
    public Optional<ReadOnlyReroll> readReroll(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableReroll> jsonReroll = JsonUtil.readJsonFile(
                filePath, JsonSerializableReroll.class);
        if (!jsonReroll.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonReroll.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal value found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveReroll(ReadOnlyReroll reroll) throws IOException {
        saveReroll(reroll, filePath);
    }

    @Override
    public void saveReroll(ReadOnlyReroll reroll, Path filePath) throws IOException {
        requireNonNull(reroll);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableReroll(reroll), filePath);
    }
}
