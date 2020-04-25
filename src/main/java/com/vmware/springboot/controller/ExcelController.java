package com.vmware.springboot.controller;

import com.vmware.springboot.service.EecelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/excelcontroller")
@RestController
public class ExcelController {

    @Autowired
    private EecelsService eecelsService;

    @PostMapping("/importXLS")
     public void importXLS(String filePath){
        eecelsService.importXLS(filePath);
     }

}
