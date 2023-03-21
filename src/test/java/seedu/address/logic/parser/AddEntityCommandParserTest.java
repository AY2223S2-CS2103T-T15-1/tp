package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.experimental.model.entity.Entity;
import seedu.address.experimental.model.entity.Name;
import seedu.address.experimental.model.tag.Tag;
import seedu.address.logic.commands.AddEntityCommand;
import seedu.address.obsolete.obsoletemodel.person.Address;
import seedu.address.obsolete.obsoletemodel.person.Email;
import seedu.address.obsolete.obsoletemodel.person.Phone;
import seedu.address.testutil.EntityBuilder;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalEntities.AMY;
import static seedu.address.testutil.TypicalEntities.BOB;

public class AddEntityCommandParserTest {
    private AddEntityCommandParser parser = new AddEntityCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Entity expectedEntity = new EntityBuilder(BOB).withTags(VALID_TAG_FRIEND).build();

        /*
        Need to update with tests that are more relevant to current app design
         */

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + TAG_DESC_FRIEND,
                                                                new AddEntityCommand(expectedEntity));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_AMY + NAME_DESC_BOB + TAG_DESC_FRIEND,
                                                            new AddEntityCommand(expectedEntity));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, NAME_DESC_BOB + TAG_DESC_FRIEND, new AddEntityCommand(expectedEntity));

        // multiple tags - all accepted
        Entity expectedEntityMultipleTags = new EntityBuilder(BOB).withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
                .build();
        assertParseSuccess(parser, NAME_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                                            new AddEntityCommand(expectedEntityMultipleTags));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Entity expectedEntity = new EntityBuilder(AMY).withTags().build();
        assertParseSuccess(parser, NAME_DESC_AMY, new AddEntityCommand(expectedEntity));
    }


    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddEntityCommand.MESSAGE_USAGE);
        // missing name prefix
        // Currently also very barebones; need implementation
        assertParseFailure(parser, VALID_NAME_BOB, expectedMessage);
    }



    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                                                                                            Name.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddEntityCommand.MESSAGE_USAGE));
    }
}


