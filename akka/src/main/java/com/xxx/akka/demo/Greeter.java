/**
 * 
 */
package com.xxx.akka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.UntypedActor;

/**
 * @author JIAHCH
 *
 * 2018年3月1日 下午5:38:27
 */
public class Greeter extends UntypedActor {

	private Logger logger = LoggerFactory.getLogger(Greeter.class);
	@Override
	public void onReceive(Object message) throws Throwable {

		logger.info("rev={}",message);

		this.getSender().tell("response", this.getSelf());
		
		logger.info("self={}" , this.getSelf().path().toString());
		logger.info("sender={}" , this.getSender().path().toString());
	}

}
