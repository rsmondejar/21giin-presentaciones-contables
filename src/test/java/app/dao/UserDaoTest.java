/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package app.dao;

import app.entities.User;
import junit.framework.TestCase;

/**
 *
 * @author raulsm
 */
public class UserDaoTest extends TestCase {
    
    private final String userName = "UserTest";
    private final String userPassword = "password";

    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test Create User
     * @throws Exception 
     */
    public void testCreateUser() throws Exception {
      
        boolean userCreatedSuccesfully = false;
      
        try {
            findAndDeleteUser();
             
            User user = new User(0, userName, userPassword, 1, 1);
            userCreatedSuccesfully = UserDao.create(user);
        } catch (Exception e) {
            
        } finally {
            assertEquals(userCreatedSuccesfully, true);
            findAndDeleteUser();
        }
    }
    
    /**
     * Find And Delete User
     * @throws Exception 
     */
    private void findAndDeleteUser() throws Exception {
        User user = null;

        try {
            user = UserDao.findByLoginAndPassword(userName, userPassword);
        } catch (Exception ignore) {}
        
        // If user exists, delete
        if (user != null) {
            try {
                UserDao.delete(user.getId());
            } catch (Exception ignore) {}
        }
    }
}
