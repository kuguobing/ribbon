package com.netflix.niws.client;

import com.netflix.loadbalancer.NFLoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

/**
 * This class essentially contains the RoundRobinRule class defined in the loadbalancer package
 * @author stonse
 *
 */
public class NIWSRoundRobinRule extends AbstractNIWSLoadBalancerRule{

    RoundRobinRule rule = new RoundRobinRule();
    
    @Override
    public void initWithNiwsConfig(
            NiwsClientConfig niwsClientConfig) {
       rule = new RoundRobinRule();        
    }

    @Override
    public Server choose(NFLoadBalancer lb, Object key) {       
        if (rule!=null){
            return rule.choose(lb, key);
        }else{
            throw new IllegalArgumentException("This class has not been initialized with the RoundRobinRule class");
        }
    }

}