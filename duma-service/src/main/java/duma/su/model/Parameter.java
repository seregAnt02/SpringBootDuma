package duma.su.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Parameter {
    @Setter
    @Getter
    public int id;

    @Setter
    @Getter
    public Date datetime;

    @Setter
    @Getter
    public String parameter;

    @Setter
    @Getter
    public String codparameter;

    @Setter
    @Getter
    public String lastupdate;

    @Setter
    @Getter
    public int meaning;

    @Setter
    @Getter
    public int DumaId;// внешний ключь
    //public structure.Duma duma = new structure.Duma();//навигационное свойство
}
