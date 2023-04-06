package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalEntities.getTypicalReroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.entity.Entity;
import seedu.address.testutil.EntityBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class MakeCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalReroll(), new UserPrefs());
    }

    @Test
    public void execute_newCharacter_success() {
        Entity validEntity = new EntityBuilder().buildChar();

        Model expectedModel = new ModelManager(model.getReroll(), new UserPrefs());
        expectedModel.addEntity(validEntity);

        assertCommandSuccess(new MakeCommand(validEntity), model,
                String.format(MakeCommand.MESSAGE_SUCCESS, validEntity), expectedModel);
    }

    @Test
    public void execute_duplicateCharacter_throwsCommandException() {
        Entity entityInList = model.getReroll().getEntities().getEntityList().get(0);
        assertCommandFailure(new MakeCommand(entityInList), model, MakeCommand.MESSAGE_DUPLICATE_ENTITY);
    }

}
