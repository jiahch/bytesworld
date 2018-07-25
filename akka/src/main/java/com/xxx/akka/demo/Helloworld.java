/**
 * 
 */
package com.xxx.akka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author JIAHCH
 *
 * 2018年3月1日 下午5:36:57
 */
public class Helloworld extends UntypedActor {

	private static Logger logger = LoggerFactory.getLogger(Helloworld.class);
	
	@Override
	public void preStart() throws Exception {
		
		final ActorRef greeterRef = this.getContext().actorOf(Props.create(Greeter.class) , "greeter");
		
		greeterRef.tell("req", this.getSelf());

	}

	@Override
	public void onReceive(Object message) throws Throwable {
		
		logger.info("rev={}" , message);
		if(message.equals("response")){
//			this.getContext().stop(this.getSelf());
			logger.info(this.getSelf().path().toString());
			logger.info(this.getSender().path().toString());
		}else{
			logger.info("unhandle message");
		}
	}

	public static void main(String[] args) {
		
		// 方式一
		akka.Main.main(new String[]{Helloworld.class.getName()});
		
		// 方式二
//		ActorSystem system = ActorSystem.create("Hello");
//		ActorRef ref = system.actorOf(Props.create(Helloworld.class) , "helloworld");
//		logger.info(ref.path().toString());
	}
	
}
