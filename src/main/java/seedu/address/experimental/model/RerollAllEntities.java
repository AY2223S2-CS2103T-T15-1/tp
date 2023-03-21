package seedu.address.experimental.model;

import seedu.address.experimental.model.entity.Entity;

/***/
public class RerollAllEntities extends RerollEntities<Entity> {
    /**
     * Add all entities.
     * @param lst
     */
    public void addAll(RerollEntities<? extends Entity> lst) {
        for (Entity entity : lst.getEntityList()) {
            entities.add(entity);
        }
    }
}
