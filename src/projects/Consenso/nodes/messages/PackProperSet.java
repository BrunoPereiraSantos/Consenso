package projects.Consenso.nodes.messages;

import java.util.List;

import projects.Consenso.nodes.nodeImplementations.ProperValue;
import sinalgo.nodes.messages.Message;

public class PackProperSet extends Message {
	List<ProperValue> properSet = null;
	
	/**
	 * @param properSet
	 */
	public PackProperSet(List<ProperValue> properSet) {
		super();
		this.properSet = properSet;
	}

	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return new PackProperSet(this.properSet);
	}

	public List<ProperValue> getProperSet() {
		return properSet;
	}

	public void setProperSet(List<ProperValue> properSet) {
		this.properSet = properSet;
	}
	
}
