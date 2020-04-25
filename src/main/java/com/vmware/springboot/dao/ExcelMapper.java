package com.vmware.springboot.dao;

import com.vmware.springboot.modle.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelMapper {

    public int  InsertXlsData(List<Supplier> list);
}
