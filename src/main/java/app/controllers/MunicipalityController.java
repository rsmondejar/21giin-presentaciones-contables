/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.dao.MunicipalityDao;
import app.entities.Municipality;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class MunicipalityController {
    
    public static List<Municipality> list() {
        
        // Get all municipalities
        List<Municipality> municipalities = MunicipalityDao.all();        
        
        return municipalities;
    }
}
