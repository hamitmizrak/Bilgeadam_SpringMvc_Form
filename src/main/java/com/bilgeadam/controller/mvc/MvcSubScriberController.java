package com.bilgeadam.controller.mvc;

import com.bilgeadam.dto.SubScriberDto;
import com.bilgeadam.dto.WriterDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class MvcSubScriberController {


    //sadece ekranda göstermeye yarar
    //localhost:8080/birinciuygulama
    @GetMapping("/birinci")
    @ResponseBody
    public String getQuery() {
        return "Yükleniyor ... ";
    }

    //bir sayfaya yönlendirmek için
    //localhost:8080/ikinciuygulama
    @GetMapping("/ikinci")
    public String secondMethod() {
        return "subscriper_key";
    }



    //şimdiye kadar sadece veri gösterdik artık bizde _2_query sayfasına veri göndererlim.
    //localhost:8080/dorduncuuygulama
    //@GetMapping ==> URL
    //retun ==>gidilecek sayfa
    // Model  <== Controller  ==>   View
    @GetMapping("/dorduncu")
    public String fourMethod(Model model) {
        model.addAttribute("subscriper_key","value");
        return "subscriper";
    }



    //////////////////////////////PATHVARIABLE/////////////////////////////////////////////////////////////

    @GetMapping({"yedinci", "yedinci/{param2}"})
    public String sevenMethod(Model model, @PathVariable(name = "param2", required = false) Long id23) {
        if (id23 != null) {
            model.addAttribute("subscriper_key", " Görkem Sönmez ID: " + id23);
        } else {
            model.addAttribute("subscriper_key", " Data Yok ID: ");
        }
        return "subscriper";
    }

    //////////////////////////////REQUESTPARAMETER/////////////////////////////////////////////////////////////


    //localhost:8080/onuncuuygulama?adi=Hamit&soyadi=Mızrak&numara=44
    @GetMapping("/onuncu")
    public String tenMethod(
            Model model,
            @RequestParam(name = "adi") String name,
            @RequestParam(name = "soyadi") String surname,
            @RequestParam(name = "numara", required = false, defaultValue = "99") Long number
    ) {
        String temp = name.toLowerCase();
        model.addAttribute("subscriper_key", " Selamlar  " + temp + " soydınız: " + surname + " " + number);
        return "subscriper";
    }

    ////////////////////////////Form////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/writer")
    public String getWriter(Model model) {
        //Database select
//        SubScriberDto writerDto = SubScriberDto.builder()
//                        .writerName("adınızı girmediniz")
//                        .writerSurname("Soyadınızı girmediniz")
//                        .writerAddress("address girmediniz")
//                        .writerTelephoneNumber("telefon girmediniz").build();
//        model.addAttribute("form_key",writerDto );
        return "subscriper";
    }

    //client yazdıklarını almak istiyorum
    @PostMapping("/writer")
    public String postWriter(Model model,SubScriberDto subScriberDto) {
//        log.info( subScriberDto.getId()+" "
//        +subScriberDto.getWriterName()+" "
//        +subScriberDto.getWriterSurname()+" "
//        +subScriberDto.getWriterAddress()+" "
//        +subScriberDto.getWriterTelephoneNumber()
//       );
        model.addAttribute("subscriper_key",subScriberDto );
        return "subscriper";
    }


}
