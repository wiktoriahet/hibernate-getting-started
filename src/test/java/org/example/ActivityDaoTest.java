package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActivityDaoTest {

    private static final String ACTIVITY_LABEL_RUNNING = "Running";

    @Test
    public void create() {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_RUNNING);

        //when
        ActivityModel createdActivityModel = activityDao.create(activityModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdActivityModel, "createdActivityModel is null"),
                () -> Assertions.assertNotNull(createdActivityModel.getId(), "createdActivityModel.getId() is null"),
                () -> Assertions.assertNotNull(createdActivityModel.getLabel(), "createdActivityModel.getLabel() is null"),
                () -> Assertions.assertEquals(ACTIVITY_LABEL_RUNNING, createdActivityModel.getLabel(), "createdActivityModel.getLabel() is not equal")
        );
    }

    @Test
    void read() {
        //given
        ActivityDao activityDao = new ActivityDao();
        Long id = -99L;

        //when
        ActivityModel readActivityModel = activityDao.read(id);


        //then
        Assertions.assertNull(readActivityModel, "readActivityModel is not null");

    }
}