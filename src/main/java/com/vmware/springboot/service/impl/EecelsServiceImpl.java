package com.vmware.springboot.service.impl;

import com.vmware.springboot.dao.ExcelMapper;
import com.vmware.springboot.service.EecelsService;
import com.vmware.springboot.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class EecelsServiceImpl implements EecelsService {

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private ExcelMapper excelMapper;

    public void importXLS(String filePath) {

        //判断是否为excel类型文件
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        }

        InputStream fis = null;
        try {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
