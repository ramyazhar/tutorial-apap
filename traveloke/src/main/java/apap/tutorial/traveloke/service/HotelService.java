package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface HotelService {
    // Method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    // Method untuk mendapatkan daftar Hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    // Method untuk mendapatkan data sebuah hotel berdasarkan Id
    HotelModel getHotelByIdHotel(Long idHotel);

    void deleteHotel (HotelModel hotel);

    HotelModel updateHotel(HotelModel hotel);
}
