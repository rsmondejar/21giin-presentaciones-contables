/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

//import app.entities.User;

/**
 * Base Controller.
 *
 * @author raulsm
 * @version 1.0.0
 */
abstract class BaseController {

    // @TODO: Ver si la dejo abstracta o no
    // @TODO: Controlar los permisos del usuario
//    private User auth;

    BaseController() {
        System.out.println("Comprobar los permisos del usuario logueado!!!");
        System.out.println("Definir los permisos del usuario logueado!!!");
    }

}
