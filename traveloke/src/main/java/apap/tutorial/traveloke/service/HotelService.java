package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;

import java.util.List;

public interface HotelService {
    //method menambah hotel

    void addHotel(HotelModel hotel);

    void removeHotel(HotelModel hotel);

    //method daftarin hotel yg udh kesimpen
    List<HotelModel> getHotelList();


    //method dapetin data hotel dari idnya
    HotelModel getHotelByIdHotel(String idHotel);


}
