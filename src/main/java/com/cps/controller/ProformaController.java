package com.cps.controller;

import com.cps.model.Proforma;
import com.cps.service.ProformaService;
import javaldapapp.JavaLDapConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ProformaController {

    private final ProformaService proformaService;

    public ProformaController(ProformaService proformaService) {
        this.proformaService = proformaService;
    }

    @GetMapping("/proforma")
    public String getProformaF(){

        return "proforma";
    }

    @PostMapping("/uploadproforma")
    public String uploadProformaf(@RequestParam("proforma") MultipartFile multipartFile) throws IOException {
        List<Proforma> proformaList = proformaService.uploadProforma(multipartFile);
        for(Proforma p : proformaList){
            System.out.println(p.toString());
        }
        return "viewproforma";
    }
}
