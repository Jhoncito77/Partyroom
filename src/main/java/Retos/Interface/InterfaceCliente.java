/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Interface;

import Retos.Modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 57300
 */
public interface InterfaceCliente extends CrudRepository<Cliente,Integer>{
    
}
