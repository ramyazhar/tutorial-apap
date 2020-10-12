package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel updateKamar(KamarModel kamar);

    KamarModel getKamarByNoKamar(Long noKamar);

    void removeKamar(KamarModel kamar);

//    List<KamarModel> findAllByKamarModelByNamaKamarAndKapasitasKamar(String nama, Integer kapasitas);
    List<KamarModel> getKamarByNamaKamarDanKapasitas(String nama, Integer kapasitas);
}
