package com.ParkCore.controller;

import com.ParkCore.service.impl.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificacaoService notificationService;

}
