package com.gslab.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gslab.sample.entity.Message;

@Service
public class MessageService {

	public List<Message> getAllMessages() {
		List<Message> messages = new ArrayList<>();
		
		Message message1 = new Message();
		message1.setAge(20);
		message1.setGender("Male");
		message1.setPreDefinedMessageText("This is sample message 1");
		messages.add(message1);
		
		Message message2 = new Message();
		message2.setAge(20);
		message2.setGender("Male");
		message2.setPreDefinedMessageText("This is sample message 2");
		messages.add(message2);
		
		Message message3 = new Message();
		message3.setAge(20);
		message3.setGender("Male");
		message3.setPreDefinedMessageText("This is sample message 3");
		messages.add(message3);
		
		Message message4 = new Message();
		message4.setAge(20);
		message4.setGender("Male");
		message4.setPreDefinedMessageText("This is sample message 4");
		messages.add(message4);
		
		return messages;
	}
}
