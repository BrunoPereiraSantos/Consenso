package projects.Consenso.nodes.timers;

import projects.Consenso.nodes.messages.Decide;
import projects.Consenso.nodes.nodeImplementations.Vertice;
import sinalgo.nodes.timers.Timer;

public class TimerDecide extends Timer {
	Decide pkt = null;
	
	/**
	 * @param pkt
	 */
	public TimerDecide(Decide pkt) {
		super();
		this.pkt = pkt;
	}



	@Override
	public void fire() {
		// TODO Auto-generated method stub
		((Vertice) node).broadcast(this.pkt);

	}

}
