/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Repositorio;

import Retos.Interface.InterfacePartyroom;
import Retos.Modelo.Partyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 57300
 */
@Repository
public class RepositorioPartyroom {
    @Autowired
    private InterfacePartyroom crud;
    

    public List<Partyroom> getAll(){
        return (List<Partyroom>) crud.findAll();       
    }
    
    public Optional <Partyroom> getPartyroom(int id){
        return crud.findById(id);
    }
    
    public Partyroom save(Partyroom partyroom){
        return crud.save(partyroom);
    }

    public void delete (Partyroom partyroom){
        crud.delete(partyroom);
    }
}
