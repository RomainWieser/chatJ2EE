package eu.ensg.chat;

public class EventMessage {

	private String eventType;
	private String name;

//	public EventMessage(String eventType, String name)
//	{
//		this.eventType= eventType;
//		this.name = name;
//	}
	
    public String getEventType() {
        return eventType;
    }
   
    public String getName() {
        return name;
    }
	
}

//enum EventType {
//
//	CONNECT, DISCONNECT
//
//}