package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamar);

    KamarModel getKamarByIdKamar(Long idkamar);

    KamarModel changeKamar(Long id, KamarModel kamar);

    List<KamarModel> retrieveListKamar();
}
