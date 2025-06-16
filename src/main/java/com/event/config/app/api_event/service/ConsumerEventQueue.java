package com.event.config.app.api_event.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.event.config.app.api_event.dto.CreateEventDto;
import com.event.config.app.api_event.model.Event;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConsumerEventQueue {


	@Autowired
    private ObjectMapper objectMapper;

	@Autowired
	private final EventService service;

	public ConsumerEventQueue(
           EventService service,
            ObjectMapper objectMapper) {
		this.service = service;
        this.objectMapper = objectMapper;
    }


    @RabbitListener(queues ="${NAME_QUEUE}")
    public void receive(@Payload String message) {
        log.info("Received message: {}", message);
        try {

            CreateEventDto eventDto = objectMapper.readValue(message, CreateEventDto.class);

            Event savedEvent = service.createEvent(eventDto);
            log.info("Event processed and saved to the database: {}", savedEvent);

			makeSlow();
        } catch (Exception e) {
            log.error("Error processing message", e);
        }
    }

	private void makeSlow() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
