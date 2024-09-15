package duma.su.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Parameter {
    @Setter
    @Getter
    public long id;

    @Setter
    @Getter
    public Date datetime;

    @Setter
    @Getter
    public String parameter;

    @Setter
    @Getter
    public String codParameter;

    @Setter
    @Getter
    public String lastUpdate;

    @Setter
    @Getter
    public int meaning;

    @Setter
    @Getter
    public int DumId;// внешний ключь
}
