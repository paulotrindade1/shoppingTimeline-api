package urlTest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class Event {
	private String event;
	private String timestamp;
	private double revenue;
	private List<CustomData> custom_data;
	
	public Event(String event, String timestamp, double revenue, List<CustomData> custom_data) {
		this.event = event;
		this.timestamp = timestamp;
		this.revenue = revenue;
		this.custom_data = custom_data;
	}

	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public double getRevenue() {
		return revenue;
	}
	
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	public List<CustomData> getCustom_data() {
		return custom_data;
	}
	
	public void setCustom_data(List<CustomData> custom_data) {
		this.custom_data = custom_data;
	}
	
}
