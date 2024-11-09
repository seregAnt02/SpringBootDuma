package duma.services;

import duma.model.Parameter;
import duma.repository.ParameterRepository;
import lombok.extern.slf4j.Slf4j;
//import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Date;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class StandartParameterService {
    private ParameterRepository repository;
    private static long sequence = 1L;

    public StandartParameterService(ParameterRepository repository){
        this.repository = repository;

        add("modbus #1");
        add("modbus #2");
    }

    public List<Parameter> getAll(){
        return this.repository.findAll();
    }
    public Parameter getParameterById(long id){
        Parameter parameter = null;
        if(id > 0){
            try {
                parameter = this.repository.findById(id).get();
            }catch (NoSuchElementException ex){
                ex.getStackTrace();
            }
        }
        return parameter;
    }

    public void update(Parameter parameter){
        try{
            Parameter model = new Parameter();
            model.setId(parameter.getId());
            model.setDatetime(new Date());
            model.setParameter(parameter.getParameter());
            model.setCodParameter(parameter.getCodParameter());
            model.setLastUpdate(parameter.getLastUpdate());
            model.setMeaning(parameter.getMeaning());
            this.repository.save(model);
            log.info("Параметер обновлен!: " + model.getDatetime());

        }catch (NoSuchElementException ex){
            ex.getStackTrace();
        }
    }

    public Parameter add(String nameParameter){
        Parameter parameter = null;
        try{
            parameter = new Parameter();
            parameter.setId(sequence++);
            parameter.setDatetime(new Date());
            parameter.setParameter(nameParameter);
            parameter.setCodParameter("MQ");
            parameter.setLastUpdate("MQ-2");
            parameter.setMeaning(120);
            this.repository.save(parameter);
        }catch (NoSuchElementException ex){
            ex.getStackTrace();
        }
        return parameter;
    }

    public Parameter deleteParameter(long id) {
        Parameter parameter = getParameterById(id);
        if(parameter != null){
            repository.delete(parameter);
        }
        return parameter;
    }

    public List<Parameter> getAllParameter(){
        return this.repository.findAll();
    }
}
