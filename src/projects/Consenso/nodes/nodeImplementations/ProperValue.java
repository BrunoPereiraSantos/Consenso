package projects.Consenso.nodes.nodeImplementations;

public class ProperValue {
	public int v, phaseLock;

	/**
	 * @param v
	 * @param phaseLock
	 */
	public ProperValue(int v, int phaseLock) {
		this.v = v;
		this.phaseLock = phaseLock;
	}
	
	public ProperValue(int v) {
		this.v = v;
		this.phaseLock = 0;
	}

	@Override
	public String toString() {
		return "ProperValue [v=" + v + ", phaseLock=" + phaseLock + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof ProperValue){
			ProperValue tmp = (ProperValue) obj;
			if(tmp.v == this.v)
			return true;
		}
		return false;
	}
}
