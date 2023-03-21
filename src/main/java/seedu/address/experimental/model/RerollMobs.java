package seedu.address.experimental.model;

import seedu.address.experimental.model.entity.Mob;

/**
 * Abstraction of all Mobs
 */
public class RerollMobs extends RerollEntities<Mob> {

    // for convenience
    private final UniqueEntityList mobs = entities;

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof RerollMobs
                && mobs.equals(((RerollMobs) other).mobs));
    }
}
