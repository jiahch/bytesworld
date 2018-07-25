/**
 * 
 */
package com.xxx.akka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author JIAHCH
 *
 * 2018年4月26日 上午11:04:41
 */
public class ConfigLoader {
	
	private static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    // 默认加载 application.conf 配置文件
	public static void main(String[] args) {
//		RemoteSys
//		ActorSystem system = ActorSystem.create("Extension-Test");  
//      Config config = system.settings().config(); 
        ActorSystem remoteSys = ActorSystem.create("RemoteSys-name", ConfigFactory.load().getConfig("RemoteSys"));
        Config config = remoteSys.settings().config(); 
        logger.info(config.toString());
	}
	
}
