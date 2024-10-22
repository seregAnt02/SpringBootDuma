package duma.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "parameters")
@Data
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;


    @Column(name = "datetime")
    public Date datetime;

    @Column(name = "parameter")
    public String parameter;

    @Column(name = "codParameter")
    public String codParameter;

    @Column(name = "lastUpdate")
    public String lastUpdate;

    @Column(name = "meaning")
    public int meaning;


    //public int DumId;// внешний ключь
}
