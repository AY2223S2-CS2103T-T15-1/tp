package seedu.address.experimental.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.entity.*;
import seedu.address.model.entity.Template;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Template}
 */
public class JsonAdaptedTemplate {
    private final String name;
    private final JsonAdaptedStats stats;
    private final int level;
    private final int xp;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedTemplate} with the given character details.
     */
    @JsonCreator
    JsonAdaptedTemplate(@JsonProperty("name") String name, @JsonProperty("stats") JsonAdaptedStats stats,
                         @JsonProperty("level") int level, @JsonProperty("xp") int xp,
                         @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.name = name;
        this.stats = stats;
        this.level = level;
        this.xp = xp;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Template} into this class for Jackson use.
     */
    public JsonAdaptedTemplate(Template source) {
        name = source.getName().fullName;
        stats = new JsonAdaptedStats(source.getStats());
        level = source.getLevel();
        xp = source.getXP();
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted Character object into the model's {@code Template} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted character.
     */
    public Template toModelType() throws IllegalValueException {
        // dont care about error...
        Stats stat = stats.toModalType();
        final List<Tag> tags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            tags.add(tag.toModelType());
        }
        final Set<Tag> modelTags = new HashSet<>(tags);
        // To add inventory
        return new Template(new Name(name), stat, level, xp, Inventory.emptyInventory(), modelTags);
    }

}