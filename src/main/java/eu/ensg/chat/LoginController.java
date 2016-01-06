package eu.ensg.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private UserRepository repository;
	
	@MessageMapping("/users")
    @SendTo("/topic/room1/admin")
    public EventMessage newUser(EventMessage eventMessage) throws Exception {
    	repository.save(new User(eventMessage.getName()));
        return eventMessage;
    }
	
	@RequestMapping("/users")
    public Iterable<User> getAllUser() {
        return repository.findAll();
    }
	
	@RequestMapping("/user")
    public User getUser(@RequestParam(value="name") String name) {
        return repository.findByName(name);
    }
	
//	@RequestMapping(value = "/user",method=RequestMethod.PUT)
//    public String putUser(@RequestBody User user) {
//        repository.save(user);
//        return "";
//    }
}
