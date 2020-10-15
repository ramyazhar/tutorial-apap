
package apap.tutorial.traveloke.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="hotel")
public class HotelModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=30)
    @Column(name="namaHotel", nullable = false)
    private String namaHotel;

    @NotNull
    @Size(max=30)
    @Column(name="alamat", nullable = false)
    private String alamat;

    @Column(name="nomorTelepon", nullable = false)
    private @NotNull @Size(max = 30) String nomorTelepon;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KamarModel> listKamar;

//    public HotelModel(
//            Long id,
//            @NotNull @Size(max = 30) String namaHotel,
//            @NotNull @Size(max = 30) String alamat,
//            @NotNull @Size(max = 30) String nomorTelepon,
//            List<KamarModel> listKamar) {
//        this.id = id;
//        this.namaHotel = namaHotel;
//        this.alamat = alamat;
//        this.nomorTelepon = nomorTelepon;
//        this.listKamar = listKamar;
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String noTelepon) {
        this.nomorTelepon = noTelepon;
    }

    public List<KamarModel> getListKamar() {
        return listKamar;
    }

    public void setListKamar(List<KamarModel> listKamar) {
        this.listKamar = listKamar;
    }
}