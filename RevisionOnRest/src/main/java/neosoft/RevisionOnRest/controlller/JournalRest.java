package neosoft.RevisionOnRest.controlller;

import ch.qos.logback.core.net.SyslogOutputStream;
import neosoft.RevisionOnRest.entity.JournalEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalRest {
    //we nneed a map to store all the values of the entities
    Map<Long, JournalEntity> jentity=new HashMap<>();
    @GetMapping
    public  String welcome(){
        return "hello from mutahir ";
    }
    @GetMapping("/getAllTheJournal")
    public List<JournalEntity> getAllEntity(){
         return new ArrayList<>(jentity.values());
    }
    @PostMapping("/createEntity")
    public  boolean createNewEntity(@RequestBody JournalEntity entity){
        jentity.put((long)entity.getJid(),entity);
        return true;


    }
    @PutMapping("/{id}")
    public boolean updateJournalEntity(@PathVariable Long id,@RequestBody JournalEntity entitynew){
        jentity.put(id,entitynew);
        return true;
    }

}
