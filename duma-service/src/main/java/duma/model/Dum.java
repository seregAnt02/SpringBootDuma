package duma.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "dumas")
@Data
public class Dum {

    private static long sequence = 1L;

    public Dum(){
        this.id = sequence++;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    /*@Setter
    @Getter
    public Date datetime;

    @Setter
    @Getter
    public String macAddress;

    @Setter
    @Getter
    public String ipAddress;

    @Setter
    @Getter
    public int port;*/

    @Column(name = "status")
    public String status;

    /*@Setter
    @Getter
    public int number;


    @Setter
    @Getter
    public int age;*/
}
