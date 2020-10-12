package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KamarServiceImpl implements KamarService{
    @Autowired
    KamarDb kamarDb;

    @Override
    public void addKamar(KamarModel kamar){
        kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> findAllKamarByIdHotel(Long idHotel){
        return kamarDb.findByHotelId(idHotel);
    }
    @Override
    public KamarModel updateKamar(KamarModel kamar){
        KamarModel targetKamar = kamarDb.findByNoKamar(kamar.getNoKamar());

        try {
            targetKamar.setNamaKamar(kamar.getNamaKamar());
            targetKamar.setTipe(kamar.getTipe());
            targetKamar.setKapasitasKamar(kamar.getKapasitasKamar());
            kamarDb.save(targetKamar);
            return targetKamar;
        } catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public KamarModel getKamarByNoKamar(Long noKamar){
        return kamarDb.findByNoKamar(noKamar);
    }

    @Override
    public void removeKamar(KamarModel kamar){
        kamarDb.delete(kamar);
    }

//    @Override
//    List<KamarModel> findAllByKamarModelByNamaKamarAndKapasitasKamar(String nama, Integer kapasitas){
//        return kamarDb.getKamarModelsByNamaKamarAndKapasitasKamar(nama,kapasitas);
//    }
    @Override
    List<KamarModel> getKamarByNamaKamarDanKapasitas(String nama, Integer kapasitas){
        return kamarDb.findAllByNamaKamarAndKapasitasKamar(nama, kapasitas);
    }
}
