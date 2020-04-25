package com.vmware.springboot.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {

    private List<Object> datas = new ArrayList<>();
    @Override
    public void invoke(Object object, AnalysisContext context) {
        if (object != null) {
            datas.add(object);
            doSomething(object);//根据自己业务做处理
        }
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
