package ssx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssx.dao.IDaoD;
import ssx.entity.DBSchemaD;

@Service
public class ServiceD {

    @Autowired
    IDaoD iDaoD;

    public DBSchemaD que(String name){
        return iDaoD.que(name);
    }

    public boolean add(DBSchemaD d){
        return iDaoD.add(d);
    }
}
