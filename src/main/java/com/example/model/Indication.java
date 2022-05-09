package main.java.com.example.model;



import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Indication extends Etape {
    @Id
    @GeneratedValue
    private int idIndication;
    private String indication ;

    private String srcVideo;
    
    private int srcImage;
    

}
