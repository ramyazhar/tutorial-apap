package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //routing url yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            //request param yang ingin dibawa
            @RequestParam(value= "idHotel", required = true) String idHotel,
            @RequestParam(value= "namaHotel", required = true) String namaHotel,
            @RequestParam(value= "alamat", required = true) String alamat,
            @RequestParam(value= "noTelepon", required = true) String noTelepon,
            Model model
    ){

        //membuat objek hotelmodel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        //memanggil service addhotel
        hotelService.addHotel(hotel);

        // add variabel id hotel ke 'idhotel' untuk dirender dalam thymeleaf
        model.addAttribute("idHotel", idHotel);

        //return view template yang digunakan
        return "add-hotel";

    }
    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){

        //mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        //add variabel semua hotel model ke listhotel untuk dirender pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return  "viewall-hotel";
    }
    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value= "idHotel") String idHotel,
            Model model){

        //mendapatkan Hotelmodel sesuai dengan idhotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        //cek keberadaan hotelnya duls gann
        if(hotel == null){
            return "no-hotel";
        }

        //add variabel hotel model ke hotel untuk dirender pada thymeleaf
        model.addAttribute("hotel",hotel);
        return "view-hotel";
    }

    @RequestMapping("hotel/view/id-hotel/{idHotel}")
    public String viewHotelWithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model){

        //mendapatkan hotel model sesuai dengan idhotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        //cek keberadaan hotelnya duls gann
        if(hotel == null){
            return "no-hotel";
        }

        //add variabel hotel model ke hotel untuk dirender pada thymeleaf
        model.addAttribute("hotel",hotel);
        return "view-hotel";
    }

    @RequestMapping("hotel/update/id-hotel/{idHotel}/no-telepon/{nomor}")
    public String updateNomorHotelWithPathVariable(

               //     http://localhost:8080/hotel/update/id-hotel/1/no-telepon/021752xxxx
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "nomor") String nomor,
            Model model){
        //mendapatkan hotel model sesuai dengan idhotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);


        //cek keberadaan hotelnya duls gann
        if(hotel==null){
            return "no-hotel";
        }

        //set nomornya sesuai di url
        hotel.setNoTelepon(nomor);

        //add variabel hotel model ke hotel untuk dirender pada thymeleaf
        model.addAttribute("hotel",hotel);

        return "update-hotel";
    }
    @RequestMapping("hotel/delete/id-hotel/{idHotel}")
    //http://localhost:8080/hotel/delete/id-hotel/1.
    public String deleteHotelWithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model){

        //mendapatkan hotel model sesuai dengan idhotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        //cek keberadaan hotelnya duls gann
        if(hotel == null){
            return "no-hotel";
        }

        //hapus hotelnya duls lach
        hotelService.removeHotel(hotel);

        //add variabel hotel model ke hotel untuk dirender pada thymeleaf
        model.addAttribute("hotel",hotel);
        return "delete-hotel";
    }


}
