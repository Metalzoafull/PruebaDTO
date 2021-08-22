package pruebaPersonal.pruebaDTO.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "categories")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull(message = "Name can not be empty")
    private String name;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private boolean deleted = Boolean.FALSE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date creationDate;

    //sin este metodo no se agrega la fecha de creacion al creationDate
    @PrePersist
    private void onCreate(){
        creationDate = new Date();
    }

    @UpdateTimestamp
    private Date updatedate;


}