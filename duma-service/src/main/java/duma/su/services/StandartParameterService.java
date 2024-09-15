package duma.su.services;

import duma.su.model.Dum;
import duma.su.model.Parameter;
import duma.su.repository.ParameterRepository;
import lombok.extern.slf4j.Slf4j;
//import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Date;

@Slf4j
@Service
public class StandartParameterService {
    private ParameterRepository repository;
    private static long sequence = 1L;

    public StandartParameterService(ParameterRepository repository){
        this.repository = repository;
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

  /*  public List<Dum> getAllDum(){
        return this.repository.findAll();
    }*/
}
