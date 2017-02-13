package com.chaos.dr.strange.seed

import akka.actor.{Actor, ActorLogging}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent._

/**
  * Created by zcfrank1st on 13/02/2017.
  */
class ClusterSeedListener extends Actor with ActorLogging {
  val cluster = Cluster(context.system);

  // subscribe to cluster changes, re-subscribe when restart
  override def preStart(): Unit = {
    //#subscribe
    cluster.subscribe(self, initialStateMode = InitialStateAsEvents, classOf[MemberEvent], classOf[UnreachableMember])
  };

  override def postStop(): Unit = cluster.unsubscribe(self);

  def receive = {
    case MemberUp(member) =>
      log.info("Member is Up: {}", member.address)

    case UnreachableMember(member) =>
      log.info("Member detected as unreachable: {}", member)

    case MemberRemoved(member, previousStatus) =>
      log.info("Member is Removed: {} after {}", member.address, previousStatus);

    case _: MemberEvent => // ignore
  }

}