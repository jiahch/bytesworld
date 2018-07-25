/**
 * 
 */
package com.xxx.akka.demo;

import akka.actor.ActorPath;
import akka.actor.ActorRef;

/**
 * @author JIAHCH
 *
 * 2018年4月26日 上午11:20:55
 */
public class RemoteActor extends ActorRef  {

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see akka.actor.ActorRef#path()
	 */
	@Override
	public ActorPath path() {
		// TODO Auto-generated method stub
		return null;
	}

}
