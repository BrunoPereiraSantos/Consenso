package projects.Consenso.nodes.messages;

import java.util.List;

import sinalgo.nodes.messages.Message;

public class PackW extends Message {
	List<Integer> w = null;
	
	/**
	 * @param w
	 */
	public PackW(List<Integer> w) {
		super();
		this.w = w;
	}

	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return new PackW(this.w);
	}

	public List<Integer> getW() {
		return w;
	}

	public void setW(List<Integer> w) {
		this.w = w;
	}
	

}
