package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{
//    private final WebClient webClient;
    @Autowired
    private KamarDb kamarDb;


    @Override
    public KamarModel createKamar(KamarModel kamar) {
        return kamarDb.save(kamar);
    }

    @Override
    public KamarModel getKamarByIdKamar(Long idkamar){
        Optional<KamarModel> kamar = kamarDb.findById(idkamar);
        if(kamar.isPresent()){
            return kamar.get();
        }else{
            throw new NoSuchElementException();
        }
    }
    @Override
    public KamarModel changeKamar(Long id, KamarModel kamarupdate) {
        KamarModel kamar = getKamarByIdKamar(id);
        kamar.setNamaKamar(kamarupdate.getNamaKamar());
        kamar.setKapasitasKamar(kamarupdate.getKapasitasKamar());
        kamar.setTipe(kamarupdate.getTipe());
        return kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> retrieveListKamar() {
        return kamarDb.findAll();
    }

    @Override
    public void deleteKamar(Long id) {
        KamarModel kamar = getKamarByIdKamar(id);
//        if(kamar != null){
            kamarDb.delete(kamar);
//        }else {
//            throw new UnsupportedOperationException();
//        }
    }




}
