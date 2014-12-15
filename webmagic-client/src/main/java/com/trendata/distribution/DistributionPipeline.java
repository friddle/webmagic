package com.trendata.distribution;

import java.util.Map;

/**
 * Created by friddle on 12/13/14.
 */
public interface DistributionPipeline{
    public void process(Object object,Class type) throws Exception;
    public void setConfiguration(Map<String,String> maps);
}
