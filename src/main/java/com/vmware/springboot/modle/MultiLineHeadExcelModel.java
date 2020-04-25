package com.vmware.springboot.modle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MultiLineHeadExcelModel  extends BaseRowModel {

    @ExcelProperty(value = {"head1","head1","head31"},index = 0)
    private String p1;

    @ExcelProperty(value = {"head1","head1","head32"},index = 1)
    private String p2;

    @ExcelProperty(value = {"head3","head3","head3"},index = 2)
    private String p3;

    @ExcelProperty(value = {"head4","head4","head4"},index = 3)
    private String p4;

    @ExcelProperty(value = {"head5","head51","head52"},index = 4)
    private String p5;

    @ExcelProperty(value = {"head6","head61","head611"},index = 5)
    private String p6;

    @ExcelProperty(value = {"head6","head61","head612"},index = 6)
    private String p7;

    @ExcelProperty(value = {"head6","head62","head621"},index = 7)
    private String p8;

    @ExcelProperty(value = {"head6","head62","head622"},index = 8)
    private String p9;
}
