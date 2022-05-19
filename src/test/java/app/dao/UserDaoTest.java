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
             
            User user = new User(userName, userPassword, 1, 1);
            Integer id = (new UserDao()).create(user);
            userCreatedSuccesfully = id != null;
        } catch (Exception e) {
            
        } finally {
            assertEquals(userCreatedSuccesfully, true);
            findAndDeleteUser();
        }
    }
    
    /**
     * Test Delete User
     * @throws Exception 
     */
    public void testDeleteUser() throws Exception {
      
        boolean userDeletedSuccesfully = false;
      
        try {
            findAndDeleteUser();
             
            UserDao userDao = new UserDao();
            
            User user = new User(userName, userPassword, 1, 1);
            userDao.create(user);
            
            user = userDao.findByLoginAndPassword(userName, userPassword);
            userDeletedSuccesfully = userDao.delete(user.getId());
        } catch (Exception e) {
            
        } finally {
            assertEquals(userDeletedSuccesfully, true);
            findAndDeleteUser();
        }
    }
    
        /**
     * Test Delete User
     * @throws Exception 
     */
    public void testUpdateUser() throws Exception {
      
        boolean userUpdatedSuccesfully = false;
      
        try {
            findAndDeleteUser();
            
            UserDao userDao = new UserDao();
             
            User user = new User(userName, userPassword, 1, 1);
            userDao.create(user);
            
            user = userDao.findByLoginAndPassword(userName, userPassword);
            
            user.setLogin("UserTestModified");
            
            userUpdatedSuccesfully = userDao.update(user.getId(), user);
            
            userDao.delete(user.getId());
        } catch (Exception e) {
            
        } finally {
            assertEquals(userUpdatedSuccesfully, true);
        }
    }
    
    /**
     * Find And Delete User
     * @throws Exception 
     */
    private void findAndDeleteUser() throws Exception {
        User user = null;

        UserDao userDao = new UserDao();
        
        try {
            user = userDao.findByLoginAndPassword(userName, userPassword);
        } catch (Exception ignore) {}
        
        // If user exists, delete
        if (user != null) {
            try {
                userDao.delete(user.getId());
            } catch (Exception ignore) {}
        }
    }
}
