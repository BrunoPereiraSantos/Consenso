package projects.Consenso.nodes.nodeImplementations;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import projects.Consenso.nodes.messages.PackProperSet;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.gui.transformation.PositionTransformation;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.tools.Tools;

public class Processor extends Node {

	//FASE ATUAL DO ALGORITMO
	public static int phase;
	
	//PROPER SET
	private List<ProperValue> properSet;
	private List<ProperValue> properSet_tmp;
	
	//diz se o nó enviou a msg com propoerSet
	private boolean sentMyProperSet;
	
	//contador de mensagens recebidas
	private int coutRcvMsg;
	private int numberOfProcessor;
	
	@Override
	public void handleMessages(Inbox inbox) {
		// TODO Auto-generated method stub
		while(inbox.hasNext()) {
			Message msg = inbox.next();
			if(msg instanceof PackProperSet) {
			// handle this type of message
				PackProperSet a =  (PackProperSet)msg;
				
				System.out.println(a.getProperSet());
				coutRcvMsg++;
				
				//adiciona os que recebe inclusive o dele
				properSet_tmp.addAll(a.getProperSet());
				if((this.ID == phase) && (coutRcvMsg == Tools.getNodeList().size() - 1)){
					handleProperSet(a);
				}
			}
		}
	}

	private void handleProperSet(PackProperSet a) {
		// TODO Auto-generated method stub
		ProperValue v = new ProperValue(0,0);
		ProperValue tmp;
		int max = 0;
		
		properSet_tmp.addAll(properSet);
		
		Iterator<ProperValue> it = properSet_tmp.listIterator();
		
		while(it.hasNext()){
			tmp = (ProperValue) it.next();
			//System.out.println("freq de "+tmp+"   = "+ Collections.frequency(properSet_tmp, tmp));
			if( Collections.frequency(properSet_tmp, tmp) > max){
				max = Collections.frequency(properSet_tmp, tmp);
				v = tmp;
			}
		}
		
		System.out.println("deois "+v);
		
		
	}

	@Override
	public void preStep() {
		// TODO Auto-generated method stub
		if(!isSentMyProperSet() && this.ID != phase){
			setSentMyProperSet(true);
			
//			Iterator<ProperValue> it = properSet.listIterator();
//			ProperValue tmp;
//			while(it.hasNext()){
//				tmp = (ProperValue) it.next();
//				tmp.phaseLock = phase;
//			}
			
			PackProperSet pkt = new PackProperSet(properSet);
			send(pkt, Tools.getNodeByID(phase));
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		coutRcvMsg = 0;
		Random generator = new Random();
		properSet = new ArrayList<ProperValue>();
		properSet_tmp = new ArrayList<ProperValue>();
		ProperValue v = new ProperValue(1 + generator.nextInt(10));
		properSet.add(v);
		//System.out.println("ID "+this.ID+"  "+properSet);
		
		if(this.ID == 1){
			phase = 1;
		}
		
	}

	@Override
	public void neighborhoodChange() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRequirements() throws WrongConfigurationException {
		// TODO Auto-generated method stub

	}
	
	 public void draw(Graphics g, PositionTransformation pt, boolean highlight) {
       
       String str = Integer.toString(this.ID) + " | " + phase;
      
       super.drawNodeAsDiskWithText(g, pt, highlight, str, 30, Color.YELLOW);
	 }
	
	public static int getPhase() {
		return phase;
	}

	public static void setPhase(int phase) {
		Processor.phase = phase;
	}

	public List<ProperValue> getProperSet() {
		return properSet;
	}

	public void setProperSet(List<ProperValue> properSet) {
		this.properSet = properSet;
	}

	public boolean isSentMyProperSet() {
		return sentMyProperSet;
	}

	public void setSentMyProperSet(boolean sentMyProperSet) {
		this.sentMyProperSet = sentMyProperSet;
	}
	
	
}
