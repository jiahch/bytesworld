/**
 * 
 */
package com.xxx.akka.demo;

import org.springframework.context.annotation.Scope;

import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberRemoved;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @author JIAHCH
 *
 * 2018年4月25日 下午5:45:03
 */
//@Named("SimpleClusterListener")  
@Scope("prototype")  
public class SimpleClusterListener extends UntypedActor {  
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);  
    Cluster cluster = Cluster.get(getContext().system());  
  
    // subscribe to cluster changes  
    @Override  
    public void preStart() {  
        cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(), MemberEvent.class, UnreachableMember.class);  
    }  
  
    // re-subscribe when restart  
    @Override  
    public void postStop() {  
        cluster.unsubscribe(getSelf());  
    }  
  
    @Override  
    public void onReceive(Object message) {  
        if (message instanceof MemberUp) {  
            MemberUp mUp = (MemberUp) message;  
            log.info("Member is Up: {}", mUp.member());  
  
        } else if (message instanceof UnreachableMember) {  
            UnreachableMember mUnreachable = (UnreachableMember) message;  
            log.info("Member detected as unreachable: {}", mUnreachable.member());  
  
        } else if (message instanceof MemberRemoved) {  
            MemberRemoved mRemoved = (MemberRemoved) message;  
            log.info("Member is Removed: {}", mRemoved.member());  
  
        } else if (message instanceof MemberEvent) {  
            // ignore  
  
        } else {  
            unhandled(message);  
        }  
  
    }  
}  
