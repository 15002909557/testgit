package com.vmware.springboot.utils;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.util.CollectionUtils;
import com.alibaba.excel.util.StringUtils;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ExcelUtil {
    private static Log log = LogFactory.getLog(ExcelUtil.class);
    private static Sheet initSheet;
    static {
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
        initSheet.setAutoWidth(Boolean.TRUE);
    }

    /* *
     * @param filePath :absolute path
     * @return
        */
    public static List<Object> readLessThan1000Row(String filePath){
        return readLessThan1000RowBySheet(filePath,null);
    }

   /* *
     *      sheetNo: default:1
     *      headLineMun: the default is 0, mean read by 1 row
   */
    public static List<Object> readLessThan1000RowBySheet(String filePath, Sheet sheet){
        if(!StringUtils.hasText(filePath)){
            return null;
        }
        sheet = sheet != null ? sheet : initSheet;
        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            return EasyExcelFactory.read(fileStream, sheet);
        } catch (FileNotFoundException e) {
            log.info("can not find the file：{}"+filePath);
        }finally {
            try {
                if(fileStream != null){
                    fileStream.close();
                }
            } catch (IOException e) {
                log.info("read file is fail, the reason is：{}", e);
            }
        }
        return null;
    }

    public static List<Object> readMoreThan1000Row(String filePath){
        return readMoreThan1000RowBySheet(filePath,null);
    }

    public static List<Object> readMoreThan1000RowBySheet(String filePath, Sheet sheet){
        if(!StringUtils.hasText(filePath)){
            return null;
        }
        sheet = sheet != null ? sheet : initSheet;
        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(fileStream, sheet, excelListener);
            return excelListener.getDatas();
        } catch (FileNotFoundException e) {
            log.error("can not find the file：{}"+filePath);
        }finally {
            try {
                if(fileStream != null){
                    fileStream.close();
                }
            } catch (IOException e) {
                log.error("read file is fail, the reason is：{}", e);
            }
        }
        return null;
    }


    public static void writeBySimple(String filePath, List<List<Object>> data, List<String> head){
        writeSimpleBySheet(filePath,data,head,null);
    }

    public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<String> head, Sheet sheet){
        sheet = (sheet != null) ? sheet : initSheet;

        if(head != null){
            List<List<String>> list = new ArrayList<>();
            head.forEach(h -> list.add(Collections.singletonList(h)));
            sheet.setHead(list);
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data,sheet);
        } catch (FileNotFoundException e) {
            log.error("can not find the file：{}"+filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }

            } catch (IOException e) {
                log.error("write date to excel is fail,the reason is ：{}", e);
            }
        }

    }

    public static void writeWithTemplate(String filePath, List<? extends BaseRowModel> data){
        writeWithTemplateAndSheet(filePath,data,null);
    }

    public static void writeWithTemplateAndSheet(String filePath, List<? extends BaseRowModel> data, Sheet sheet){
        if(CollectionUtils.isEmpty(data)){
            return;
        }
        sheet = (sheet != null) ? sheet : initSheet;
        sheet.setClazz(data.get(0).getClass());
        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write(data,sheet);
        } catch (FileNotFoundException e) {
            log.error("can not find the file{}"+ filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                log.error("export date fail,the reason is ", e);
            }
        }

    }

    public static void writeWithMultipleSheel(String filePath,List<MultipleSheelPropety> multipleSheelPropetys){
        if(CollectionUtils.isEmpty(multipleSheelPropetys)){
            return;
        }
        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            for (MultipleSheelPropety multipleSheelPropety : multipleSheelPropetys) {
                Sheet sheet = multipleSheelPropety.getSheet() != null ? multipleSheelPropety.getSheet() : initSheet;
                if(!CollectionUtils.isEmpty(multipleSheelPropety.getData())){
                    sheet.setClazz(multipleSheelPropety.getData().get(0).getClass());
                }
                writer.write(multipleSheelPropety.getData(), sheet);
            }
        } catch (FileNotFoundException e) {
            log.error("can not find the file：{}"+filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                log.error("export data fail, the reason is ：{}", e);
            }
        }
    }

    @Data
    public static class MultipleSheelPropety{
        private List<? extends BaseRowModel> data;
        private Sheet sheet;
    }
}
