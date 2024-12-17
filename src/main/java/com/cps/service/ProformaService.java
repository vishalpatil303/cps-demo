package com.cps.service;

import com.cps.model.File;
import com.cps.model.Proforma;
import com.cps.model.ProformaF;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProformaService {

    public List<Proforma> uploadProforma(MultipartFile multipartFile) throws IOException  {
        File file = new File();
        file.setFileName(multipartFile.getOriginalFilename());
       // file.setFileLocation(multipartFile.get);
        List<Proforma> proformas = null;
        String fileType = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        InputStream inputStream = multipartFile.getInputStream();
        proformas =  uploadCSVfile(inputStream);

        return proformas;
    }



    private List<Proforma> uploadCSVfile(InputStream inputStream) throws IOException {


        String[] header = { "Sr. No.","Liability Document No in SAP","SAP Posting Year","Profit Center", "SAP ID", "CPF NO", "Employee Name", "Net Payable Amount", "Description of Claim"};
        final CSVFormat csvFormat = CSVFormat.Builder.create()
                .setHeader(header)
                .setSkipHeaderRecord(true)
                .setIgnoreHeaderCase(true)
                .setTrim(true)
                .build();
        List<Proforma> proformas= null;
        BufferedReader bufferedReader = null;
        CSVParser csvParser;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            csvParser = new CSVParser(bufferedReader,csvFormat);
            List<CSVRecord> csvRecords = csvParser.getRecords();
            ProformaF proformaF = null;
            proformas = new ArrayList<>();
            for(CSVRecord csvRecord : csvRecords){
                proformaF = new ProformaF();
                proformaF.setSrNo(Integer.parseInt(csvRecord.get("Sr. No.")));
                proformaF.setDocumentNo(Long.parseLong(csvRecord.get("Liability Document No in SAP")));
                proformaF.setPostingYear(Integer.parseInt(csvRecord.get("SAP Posting Year")));

                proformaF.setProfitCenter(Integer.parseInt(csvRecord.get("Profit Center")));
                proformaF.setSapId(csvRecord.get("SAP ID"));
                proformaF.setCpfNo(Long.parseLong(csvRecord.get("CPF NO")));
                proformaF.setEmployeeName(csvRecord.get("Employee Name"));
                proformaF.setPayableAmount(Float.parseFloat(csvRecord.get("Net Payable Amount").replaceAll("[^0-9]","")));
                proformaF.setClaimDescription(csvRecord.get("Description of Claim"));

                proformas.add(proformaF);
            }

        }finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
        return proformas;
    }
}
