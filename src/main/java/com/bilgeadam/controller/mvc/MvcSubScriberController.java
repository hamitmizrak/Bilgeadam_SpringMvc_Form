package com.bilgeadam.controller.mvc;

import com.bilgeadam.dao.SubScriberDao;
import com.bilgeadam.dto.SubScriberDto;
import com.bilgeadam.dto.WriterDto;
import com.bilgeadam.io.SubscriberFileWriterReader;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class MvcSubScriberController {


    //localhost:7777/subscriber
    //subscriperform.jsp
    @GetMapping("/subscriber")
    public String getWriter(Model model) {
        //Database select
        SubScriberDto subScriberDto=SubScriberDto.builder()
                .subScriberId(44)
                .subScriberAddress("adres alanı girmediniz")
                .subScriberName("adı girmediniz")
                .subScriberEmailAddress("email adresi girmediniz")
                .subScriberSurname("Soyadını girmediniz")
                .build();
        model.addAttribute("validation_key",subScriberDto );
        return "subscriperform";
    }

    //localhost:7777/subscriber
    //client yazdıklarını almak istiyorum
    @PostMapping("/subscriber")
    public String postWriter(Model model,SubScriberDto subScriberDto) {
        model.addAttribute("validation_key",subScriberDto );

        if(subScriberDto!=null){
            //log birimi
            log.info(subScriberDto.getSubScriberId()+" "
                    +subScriberDto.getSubScriberName()+" "
                    +subScriberDto.getSubScriberSurname()+" "
                    +subScriberDto.getSubScriberAddress()+" "
                    +subScriberDto.getSubScriberEmailAddress()
            );

            //database
            SubScriberDao subScriberDao=new SubScriberDao();
            subScriberDao.create(subScriberDto);

            //file
            SubscriberFileWriterReader file=new SubscriberFileWriterReader();
            file.bilgeadamFileWriter(subScriberDto);

            //dosya okuma
            file.bilgeadamFileReader();

            //eğer başarılı ise success.jsp sayfasına göndermek istiyorum
            return "success";
        }
        //eğer başarılı değilse aynı sayfada kalsın
        return "subscriperform";
    }



}
