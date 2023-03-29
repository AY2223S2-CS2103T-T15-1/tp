package seedu.address.logic.parser;

import java.util.regex.Pattern;

import seedu.address.logic.commands.TemplateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entity.Name;

// TODO: Improve code quality

/**
 * Parses given {@code String} of arguments in the context of TemplateCommand and returns
 * a TemplateCommand for execution
 */
public class TemplateCommandParser implements Parser<TemplateCommand> {
    @Override
    public TemplateCommand parse(String args) throws ParseException {
        boolean isValidCommand = Pattern.matches("^(\\s+[\\w]+)+\\|(\\s+[\\w]+)+$", args.trim());
        if (!isValidCommand) {
            throw new ParseException("To add");
        }
        String[] split = args.trim().split("\\|");
        return new TemplateCommand(new Name(split[0]), new Name(split[1]));
    }
}
