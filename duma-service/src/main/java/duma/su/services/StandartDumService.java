package duma.su.services;

import duma.su.model.Dum;
import duma.su.repository.DumRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class StandartDumService {
    private DumRepository repository;

    public StandartDumService(DumRepository repository){
        this.repository = repository;

        createDum("create #1");
        createDum("create #2");
    }


    private void createDum(String status){
        Dum dum = new Dum();
        dum.setStatus(status);
        this.repository.save(dum);
    }

    public List<Dum> getAllDum(){
        return this.repository.findAll();
    }
}
