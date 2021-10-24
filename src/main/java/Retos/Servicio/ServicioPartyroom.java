/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos.Servicio;

import Retos.Modelo.Partyroom;
import Retos.Repositorio.RepositorioPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57300
 */
@Service
public class ServicioPartyroom {
    @Autowired
    private RepositorioPartyroom metodosCrud;
    
    public List<Partyroom> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Partyroom> getPartyroom(int idPartyroom){
        return metodosCrud.getPartyroom(idPartyroom);
    }
    
    public Partyroom save(Partyroom partyroom){
        if(partyroom.getId()==null){
            return metodosCrud.save(partyroom);
        }else{
            Optional<Partyroom> evt=metodosCrud.getPartyroom(partyroom.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }
    public Partyroom update(Partyroom partyroom){
        if(partyroom.getId()!=null){
            Optional<Partyroom> e=metodosCrud.getPartyroom(partyroom.getId());
            if(!e.isEmpty()){
                if(partyroom.getName()!=null){
                    e.get().setName(partyroom.getName());
                }
                if(partyroom.getOwner()!=null){
                    e.get().setOwner(partyroom.getOwner());
                }
                if(partyroom.getCapacity()!=null){
                    e.get().setCapacity(partyroom.getCapacity());
                }
                if(partyroom.getDescription()!=null){
                    e.get().setDescription(partyroom.getDescription());
                }
                if(partyroom.getCategory()!=null){
                    e.get().setCategory(partyroom.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return partyroom;
            }
        }else{
            return partyroom;
        }
    }
    public boolean deletePartyroom(int idPartyroom) {
        Boolean aBoolean = getPartyroom(idPartyroom).map(partyroom -> {
            metodosCrud.delete(partyroom);
            return true;
        }).orElse(false);
        return aBoolean;
    }
        
}
