package eu.ensg.chat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String user;
    private String content;

    public String getContent() {
        return content;
    }
    
    public String getUser() {
        return user;
    }
    
    public String toString() {
        return String.format(
                "Customer[id=%d, user='%s', content='%s']",
                id, user, content);
    }
}
