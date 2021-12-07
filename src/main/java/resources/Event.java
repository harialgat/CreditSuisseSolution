package resources;

//the idea behind this class to store all the json objects as java objects
public class Event {
	public String id;
	public String state;
	public String type;
	public String host;
	public String timestamp;

	public Event(String id, String state, String type, String host, String timestamp) {
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp=" + timestamp
				+ "]";
	}

}
