package duma.su.services;

import duma.su.model.Parameter;
//import duma.su.repository.ParameterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/*@Slf4j
@Service*/
public class StandartParameterService {
    private static long sequence = 1L;
    /*private ParameterRepository repository;
    public StandartParameterService(ParameterRepository repository){
        this.repository = repository;
    }*/
   /* public Parameter createParameter(){
        Parameter parameter = new Parameter();
        parameter.setId(sequence++);
        parameter.setDatetime(new Date());
        parameter.setParameter("modbus");
        parameter.setCodParameter("MQ");
        parameter.setLastUpdate("MQ-2");
        parameter.setMeaning(120);

        return parameter;
    }*/
}
