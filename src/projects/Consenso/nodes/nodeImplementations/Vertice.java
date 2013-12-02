package projects.Consenso.nodes.nodeImplementations;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import projects.Consenso.nodes.messages.Decide;
import projects.Consenso.nodes.messages.PackW;
import projects.Consenso.nodes.timers.TimerDecide;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.gui.transformation.PositionTransformation;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;

public class Vertice extends Node {

	public static int t = 1;
	public static int turn = 1;
	public static int valueDefault = 0;
	public ProperValue lastProp;
	public List<Integer> w;
	@Override
	public void handleMessages(Inbox inbox) {
		// TODO Auto-generated method stub
		while(inbox.hasNext()) {
			Message msg = inbox.next();
			if(msg instanceof Decide){
				Decide a = (Decide) msg;
				updateLastProp(a);
			}
		}
	}

	private void updateLastProp(Decide a) {
		// TODO Auto-generated method stub
		if(a.getDecideValue().phaseLock > lastProp.phaseLock){
			lastProp = a.getDecideValue();
		}
	}

	@Override
	public void preStep() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//w = new ArrayList<Integer>();
		Random generator = new Random();
		
		//w.add(1 + generator.nextInt(10));
		lastProp = new ProperValue(1 + generator.nextInt(10), 0);
		
		if(this.ID == turn){
			lastProp.phaseLock = turn;
			Decide pkt = new Decide(lastProp);
			TimerDecide td = new TimerDecide(pkt);
			td.startRelative(1, this);
		}
	}

	@Override
	public void neighborhoodChange() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postStep() {
		// TODO Auto-generated method stub
		if(this.ID == turn){
			lastProp.phaseLock = turn;
			Decide pkt = new Decide(lastProp);
			TimerDecide td = new TimerDecide(pkt);
			td.startRelative(1, this);
		}
	}

	@Override
	public void checkRequirements() throws WrongConfigurationException {
		// TODO Auto-generated method stub

	}
	
	public void draw(Graphics g, PositionTransformation pt, boolean highlight) {

		String str = Integer.toString(this.ID) + " | " + turn + " | " + lastProp.v;

		super.drawNodeAsDiskWithText(g, pt, highlight, str, 40, Color.YELLOW);
	}

}
