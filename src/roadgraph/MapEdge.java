package roadgraph;

public class MapEdge {
	private final MapNode to;
	private final String roadName;
	private final String roadType;
	private final double length;

	public MapEdge(MapNode to,String roadName,String roadType,double length){
		this.to=to;
		this.roadName=roadName;
		this.roadType=roadType;
		this.length=length;
	}

	public MapNode getTo(){
		return to;
	}

	public String getRoadName(){
		return roadName;
	}

	public String getRoadType(){
		return roadType;
	}

	public double getLength(){
		return length;
	}

	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;

		MapEdge other=(MapEdge)obj;

		if(Double.doubleToLongBits(length)!=Double.doubleToLongBits(other.length))
			return false;
		if(roadName==null){
			if(other.roadName!=null)
				return false;
		}
		else if(!roadName.equals(other.roadName))
			return false;
		if(roadType==null){
			if(other.roadType!=null)
				return false;
		}
		else if(!roadType.equals(other.roadType))
			return false;
		if(to==null){
			if(other.to!=null)
				return false;
		}
		else if(!to.equals(other.to))
			return false;
		return true;
	}
}