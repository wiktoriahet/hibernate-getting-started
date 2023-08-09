package org.example;

import org.junit.jupiter.api.Test;

public class UserDaoIntegratedTest {

    @Test
    void createAndDelete(){
        //given
        UserDao userDao = new UserDao();
        UserModel createUserModel = new UserModel();

        //when
        UserModel createdUserModel = userDao.create(createUserModel);
        userDao.delete(createdUserModel);

        //then

    }
}
