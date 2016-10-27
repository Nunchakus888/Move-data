package com.sumscope.cdhplus.maintain.service;


import com.sumscope.cdhplus.maintain.domain.LogData;

import java.util.*;

/**
 * Created by wenshuai.li on 2016/10/25.
 */
public interface MaintainService {
    List<LogData> getFromTLOG(Map map);
    int insert2TLog(List<LogData> list);
    int deleteFromTLog(List<LogData> list);

}
