package com.gslab.sample.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gslab.sample.entity.Message;

@Service
public class MessageService {
	private List<Message> messages = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Message message1 = new Message();
		message1.setId(1);
		message1.setAge(20);
		message1.setGender("Male");
		message1.setPreDefinedMessageText("This is sample message 1");
		messages.add(message1);
		
		Message message2 = new Message();
		message2.setId(2);
		message2.setAge(25);
		message2.setGender("Female");
		message2.setPreDefinedMessageText("This is sample message 2");
		messages.add(message2);
		
		Message message3 = new Message();
		message3.setId(3);
		message3.setAge(30);
		message3.setGender("Male");
		message3.setPreDefinedMessageText("This is sample message 3");
		messages.add(message3);
		
		Message message4 = new Message();
		message4.setId(4);
		message4.setAge(35);
		message4.setGender("Female");
		message4.setPreDefinedMessageText("This is sample message 4");
		messages.add(message4);

	}
	
	public List<Message> getAllMessages() {
		return messages;
	}
	
	public Message findMessage(int messageId) {
		for (Message message : messages) {
			if (messageId == message.getId()) {
				return message;
			}
		}
		return null;
	}
	
	public Message addNewMessage(Message newMessage) {
		int msgId = 1;
		if (messages.size() != 0) {
			Message lastMsg = messages.get(messages.size() - 1);
			msgId = lastMsg.getId()  + 1;
			
		}
		newMessage.setId(msgId);
		messages.add(newMessage);
		return newMessage;
	}
	
	public Message updateMessage(Message message) {
		int messageId = message.getId();
		for (Message editMessage : messages) {
			if (messageId == editMessage.getId()) {
				editMessage.setAge(message.getAge());
				editMessage.setGender(message.getGender());
				editMessage.setPreDefinedMessageText(message.getPreDefinedMessageText());
			}
		}
		return message;
	}
	
	public boolean deleteMessage(int messageId) {
		int index = 0;
		boolean found = false;
		for (Message message : messages) {
			if (messageId == message.getId()) {
				found = true;
				break;
			}
			index++;
		}
		
		if (found) {
			messages.remove(index);
			return true;
		}
		return false;
	}
	
}
