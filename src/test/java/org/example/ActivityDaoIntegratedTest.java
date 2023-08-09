package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActivityDaoIntegratedTest {

    private static final String ACTIVITY_LABEL_RUNNING = "Running";
    public static final String ACTIVITY_LABEL_JUMPING = "Jumping";
    public static final String ACTIVITY_LABEL_DANCING = "Dancing";

    @Test
    void createAndUpdate() {
        //given
        ActivityDao activityDao = new ActivityDao();

        ActivityModel createActivityModel = new ActivityModel();
        createActivityModel.setLabel(ACTIVITY_LABEL_JUMPING);

        ActivityModel updateActivityModel = new ActivityModel();
        updateActivityModel.setLabel(ACTIVITY_LABEL_DANCING);

        //when
        ActivityModel createdActivityModel = activityDao.create(createActivityModel);
        updateActivityModel.setId(createdActivityModel.getId());
        ActivityModel updatedActivityModel = activityDao.update(updateActivityModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updatedActivityModel, "updatedActivityModel is null"),
                () -> Assertions.assertNotNull(updatedActivityModel.getId(), "updatedActivityModel.getId() is null"),
                () -> Assertions.assertEquals(ACTIVITY_LABEL_DANCING, updatedActivityModel.getLabel(), "updatedActivityModel.getLabel() is not equal"),
                () -> Assertions.assertNotEquals(ACTIVITY_LABEL_JUMPING, updatedActivityModel.getLabel(), "updatedActivityModel.getLabel() is equal")
        );
    }

    @Test
    void createAndRead() {
        //given
        ActivityDao activityDao = new ActivityDao();

        ActivityModel createActivityModel = new ActivityModel();
        createActivityModel.setLabel(ACTIVITY_LABEL_JUMPING);

        //when
        ActivityModel createdActivityModel = activityDao.create(createActivityModel);
        ActivityModel readActivityModel = activityDao.read(createdActivityModel.getId());

        //then
        //Assertions.assertNotNull(readActivityModel, "readActivityModel is null");
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readActivityModel, "readActivityModel is null"),
                () -> Assertions.assertEquals(ACTIVITY_LABEL_JUMPING, readActivityModel.getLabel(), "readActivityModel.getLabel() is not equal")
        );

    }

    @Test
    void createAndDelete() {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityModel createActivityModel = new ActivityModel();

        //when
        ActivityModel createdActivityModel = activityDao.create(createActivityModel);
        activityDao.delete(createActivityModel);

        //then

    }
}