package apap.tutorial.traveloke.restcontroller;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestService kamarRestService;

    @PostMapping(value = "/kamar")
    private String createKamar(@Valid @RequestBody KamarModel kamar, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
           kamarRestService.createKamar(kamar);
            return "add kamar suskes bos";
        }
    }

    @PutMapping(value = "/kamar/{id}")
    private String updateKamar(
            @PathVariable (value = "id") Long id,
            @RequestBody KamarModel kamar
    ){
        try{
            kamarRestService.changeKamar(id, kamar);
            return "Update kamar success";
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID "+ String.valueOf(id)+" Not Found!"
            );
        }
    }


}
