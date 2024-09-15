package duma.su.services;

import duma.su.model.Dum;
import duma.su.model.Parameter;
import duma.su.repository.DumRepository;
import lombok.extern.slf4j.Slf4j;
//import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Date;

@Slf4j
@Service
public class StandartDumService {
    private DumRepository repository;
    private static long sequence = 1L;

    public StandartDumService(DumRepository repository){
        this.repository = repository;

        createDum("create #1");
        createDum("create #2");
    }


    public Parameter createParameter(){
        Parameter parameter = new Parameter();
        parameter.setId(sequence++);
        parameter.setDatetime(new Date());
        parameter.setParameter("modbus");
        parameter.setCodParameter("MQ");
        parameter.setLastUpdate("MQ-2");
        parameter.setMeaning(120);

        return parameter;
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
