/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seeders;

import app.dao.UserDao;
import app.entities.User;
import helpers.Log;
import helpers.RandomString;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Seeder Table Users.
 *
 * @author raulsm
 */
public class UserSeeder {

    /**
     * Seeder Table Users.
     *
     * @param total Total users to add
     * @return boolean
     * @throws Exception Exception.
     */
    @SuppressFBWarnings("HARD_CODE_PASSWORD")
    public static boolean create(int total) throws Exception {
        try {
            UserDao userDao = new UserDao();
            
            int counter = 0;
            for (int i = 0; i < total; i++) {
                User user = new User();
                user.setLogin("user_" + new RandomString(5).nextString());
                user.setPassword("pass1234");
                user.setMunicipalityId(1);
                user.setRoleId(4);
                
                Integer id = userDao.create(user);
                Boolean userCreatedSuccesfully = id != null;

                if (userCreatedSuccesfully) {
                    counter++;
                }
            }

            if (counter < total) {
                throw new Exception("Se han creado %d de los %d indicados".formatted(counter, total));
            }

            return true;
        } catch (Exception exception) {
            Log.error(exception);
            throw exception;
        }
    }
}
