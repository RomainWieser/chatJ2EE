package eu.ensg.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@Autowired
	private MessageRepository repository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message send(Message message) throws Exception {
    	repository.save(message);
        return message;
    }

}