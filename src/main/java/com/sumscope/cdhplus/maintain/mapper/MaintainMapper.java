package com.sumscope.cdhplus.maintain.mapper;


import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by wenshuai.li on 2016/10/25.
 */
public class MaintainMapper {

    private SqlSessionTemplate dataServiceSessionTemplate;

    public SqlSessionTemplate getDataServiceSessionTemplate() {
        return dataServiceSessionTemplate;
    }

    public void setDataServiceSessionTemplate(SqlSessionTemplate dataServiceSessionTemplate) {
        this.dataServiceSessionTemplate = dataServiceSessionTemplate;
    }
}
