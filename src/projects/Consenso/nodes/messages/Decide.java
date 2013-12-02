package projects.Consenso.nodes.messages;

import projects.Consenso.nodes.nodeImplementations.ProperValue;
import sinalgo.nodes.messages.Message;

public class Decide extends Message {
	ProperValue decideValue = null;
	
	/**
	 * @param decideValue
	 */
	public Decide(ProperValue decideValue) {
		super();
		this.decideValue = decideValue;
	}


	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return new Decide(this.decideValue);
	}


	public ProperValue getDecideValue() {
		return decideValue;
	}

	public void setDecideValue(ProperValue decideValue) {
		this.decideValue = decideValue;
	}

	
}
