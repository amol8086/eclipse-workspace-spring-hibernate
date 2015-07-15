package com.gslab.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.sample.entity.Message;
import com.gslab.sample.service.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Resource
	private MessageService messageService;
    
    public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Message> getAllMessages() {
    	return getMessageService().getAllMessages();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Message findMessages(@PathVariable("id") int id) {
        Message message = getMessageService().findMessage(id);
		return message;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Message updateMessages(@PathVariable("id") int id, @RequestBody Message message) {
    	message.setId(id);
    	Message updatedMessage = getMessageService().updateMessage(message);
		return updatedMessage;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Message addMessages(@RequestBody Message message) {
        Message addedMessage = getMessageService().addNewMessage(message);
		return addedMessage;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteMessages(@PathVariable("id") int id) {
        boolean success = getMessageService().deleteMessage(id);
		return success;
    }
    
}
