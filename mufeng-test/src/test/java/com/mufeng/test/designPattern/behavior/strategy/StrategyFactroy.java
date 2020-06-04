package com.mufeng.test.designPattern.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 11:23
 */
public class StrategyFactroy {
    private Map<String,Strategy> strategyMap=new HashMap<>();
    public void put(String key,Strategy strategy){
        if(null==strategyMap.get(key)){
            strategyMap.put(key,strategy);
        }
    }
    public Strategy get(String key){
        return strategyMap.get(key);
    }
    public void strategeMethod(String key){
        strategyMap.get(key).strategyMethod();
    }
}
