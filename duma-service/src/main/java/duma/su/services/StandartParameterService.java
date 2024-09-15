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

        createParameter("modbus #1");
        createParameter("modbus #2");
    }

    public Parameter edit(Parameter parameter){
        Parameter model = new Parameter();
        model.setDatetime(parameter.getDatetime());
        model.setParameter(parameter.getParameter());
        model.setCodParameter(parameter.getCodParameter());
        model.setLastUpdate(parameter.getLastUpdate());
        model.setMeaning(parameter.getMeaning());
        return model;
    }

    public Parameter createParameter(String nameParameter){
        Parameter parameter = new Parameter();
        parameter.setId(sequence++);
        parameter.setDatetime(new Date());
        parameter.setParameter(nameParameter);
        parameter.setCodParameter("MQ");
        parameter.setLastUpdate("MQ-2");
        parameter.setMeaning(120);
        this.repository.save(parameter);
        return parameter;
    }

    public List<Parameter> getAllParameter(){
        return this.repository.findAll();
    }
}
