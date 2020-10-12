package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="kamar")
public class ReviewModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "nama_reviewer", nullable = false)
    private String nama_reviewer;

    @NotNull
    @Size(max = 50)
    @Column(name = "isi_review", nullable = false)
    private String isi_review;

    @NotNull
    @Size(max = 50)
    @Column(name = "saran", nullable = true)
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "kamarId", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;


}