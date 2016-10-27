package com.sumscope.cdhplus.maintain.service;

import com.sumscope.cdhplus.maintain.domain.LogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenshuai.li on 2016/10/26.
 */
@Component
@Configurable
@EnableScheduling
public class MaintainJob {
    private static final int SIZE = 1000;

    int result = 0;

    @Autowired
    private MaintainService maintainService;

    @Transactional(rollbackFor = Exception.class, timeout = 5000)
    public int doTLogJob() throws Exception {
        Map map = new HashMap();
        while (true) {
            map.put("start", 0);
            map.put("size", SIZE);
            boolean flag = doJob(map);
            if(!flag){
                break;
            }
        }
        return result;
    }


    private boolean doJob(Map map) throws Exception{
        List<LogData> lists = maintainService.getFromTLOG(map);
        result += lists.size();
        if (lists.size() == SIZE) {
            maintainService.insert2TLog(lists);
            maintainService.deleteFromTLog(lists);
            System.out.println("result========================" + result);
            return true;
        }else{
            if(lists.size() > 0) {
                maintainService.insert2TLog(lists);
                maintainService.deleteFromTLog(lists);
            }
            System.out.println("result==========================" + result);
            return false;
        }
    }
}
