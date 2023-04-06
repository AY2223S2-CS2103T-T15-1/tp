package seedu.address.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.EditModeParser;
import seedu.address.logic.parser.RerollParser;
import seedu.address.logic.parser.UiSwitchMode;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyReroll;
import seedu.address.model.entity.Entity;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {

    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final RerollParser rerollParser;
    private final EditModeParser editModeParser;
    private boolean isInEditMode;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        rerollParser = new RerollParser();
        editModeParser = new EditModeParser(model);
        isInEditMode = false;
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;

        Command command;
        if (!isInEditMode) {
            command = rerollParser.parseCommand(commandText);
        } else {
            try {
                command = editModeParser.parseCommand(commandText);
            } catch (NumberFormatException nfe) {
                throw new ParseException("Incorrect value format!");
            }
        }
        commandResult = command.execute(model);
        setMode(commandResult.getSwitchMode());
        try {
            storage.saveReroll(model.getReroll());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyReroll getReroll() {
        return model.getReroll();
    }

    @Override
    public ObservableList<Entity> getFilteredEntityList() {
        return model.getFilteredEntityList();
    }

    @Override
    public Path getRerollFilePath() {
        return model.getRerollFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }

    @Override
    public boolean getIsInEditMode() {
        return isInEditMode;
    }

    @Override
    public Entity getCurrentSelectedEntity() {
        return model.getCurrentSelectedEntity();
    }

    private void setMode(UiSwitchMode switchMode) {
        switch (switchMode) {
        case LIST:
            isInEditMode = false;
            break;
        case VIEW:
            isInEditMode = true;
            break;
        case TOGGLE:
            isInEditMode = !isInEditMode;
            break;
        default:
            break;
        }

    }
}
