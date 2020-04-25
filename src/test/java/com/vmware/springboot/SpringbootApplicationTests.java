package com.vmware.springboot;

import com.alibaba.excel.metadata.Sheet;
import com.vmware.springboot.modle.MultiLineHeadExcelModel;
import com.vmware.springboot.modle.TableHeaderExcelProperty;
import com.vmware.springboot.modle.User;
import com.vmware.springboot.service.UserService;
import com.vmware.springboot.utils.ExcelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        List<User> users=userService.getUser();
        for(User user : users) {
            System.out.println("============="+user);
        }

    }

    @Test
    public void readLessThan1000Row(){
        String filePath = "D:\\student.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
        objects.forEach(System.out::println);
    }

    @Test
    public void readLessThan1000RowBySheet(){
        String filePath = "D:\\student.xlsx";
        Sheet sheet = new Sheet(2, 1);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath,sheet);
        objects.forEach(System.out::println);
    }

    @Test
    public void readMoreThan1000Row(){
        String filePath = "D:\\student.xlsx";
        List<Object> objects = ExcelUtil.readMoreThan1000Row(filePath);
        objects.forEach(System.out::println);
    }

    @Test
    public void readMoreThan1000RowBySheet(){
        String filePath = "D:\\student.xlsx";
        Sheet sheet = new Sheet(2, 1);
        List<Object> objects = ExcelUtil.readMoreThan1000RowBySheet(filePath,sheet);
        objects.forEach(System.out::println);
    }

    @Test
    public void writeBySimple(){
        String filePath = "D:\\test.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        List<String> head = Arrays.asList("head1", "head2", "head3");
        ExcelUtil.writeBySimple(filePath,data,head);
    }

    @Test
    public void writeWithTemplate(){
        String filePath = "D:\\test.xlsx";
        ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("cmj" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("清华大学" + i);
            data.add(tableHeaderExcelProperty);
        }
        ExcelUtil.writeWithTemplate(filePath,data);
    }

    @Test
    public void writeWithMultipleSheel(){
        ArrayList<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();
        for(int j = 1; j < 4; j++){
            ArrayList<TableHeaderExcelProperty> list = new ArrayList<>();
            for(int i = 0; i < 4; i++){
                TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
                tableHeaderExcelProperty.setName("cmj" + i);
                tableHeaderExcelProperty.setAge(22 + i);
                tableHeaderExcelProperty.setSchool("清华大学" + i);
                list.add(tableHeaderExcelProperty);
            }

            Sheet sheet = new Sheet(j, 0);
            sheet.setSheetName("sheet" + j);

            ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
            multipleSheelPropety.setData(list);
            multipleSheelPropety.setSheet(sheet);

            list1.add(multipleSheelPropety);

        }
        ExcelUtil.writeWithMultipleSheel("D:\\test.xlsx",list1);
    }

    @Test
    public void writeMultiLineHeadExcelModel(){
        String filePath = "D:\\test.xlsx";
        ArrayList<MultiLineHeadExcelModel> data = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            MultiLineHeadExcelModel MultiLineHead = new MultiLineHeadExcelModel();
            MultiLineHead.setP1("1"+i);
            MultiLineHead.setP2("2"+i);
            MultiLineHead.setP3("3"+i);
            MultiLineHead.setP4("4"+i);
            MultiLineHead.setP5("5"+i);
            MultiLineHead.setP6("6"+i);
            MultiLineHead.setP7("7"+i);
            MultiLineHead.setP8("8"+i);
            MultiLineHead.setP9("9"+i);
            data.add(MultiLineHead);
        }
        ExcelUtil.writeWithTemplate(filePath,data);
    }

}
