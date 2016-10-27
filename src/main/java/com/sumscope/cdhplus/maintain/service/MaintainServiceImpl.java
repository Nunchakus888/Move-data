package com.sumscope.cdhplus.maintain.service;

import com.sumscope.cdhplus.maintain.domain.LogData;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wenshuai.li on 2016/10/25.
 */
@Service
public class MaintainServiceImpl implements MaintainService {

    @Autowired
    private SqlSessionTemplate dataServiceSessionTemplate;

    @Override
    public List<LogData> getFromTLOG(Map map) {
        return dataServiceSessionTemplate.selectList("getFromTLog", map);
    }

    @Override
    public int insert2TLog(List<LogData> list) {
        return dataServiceSessionTemplate.insert("insert2TLog", list);
    }

    @Override
    public int deleteFromTLog(List<LogData> list) {
        return dataServiceSessionTemplate.delete("delete2TLog", list);
    }

    public int createNewTable() {
        return dataServiceSessionTemplate.update("createNewTable");
    }

}
