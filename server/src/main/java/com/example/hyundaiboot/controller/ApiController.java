package com.example.hyundaiboot.controller;

import com.example.hyundaiboot.domain.User;
import com.example.hyundaiboot.domain.UserDevice;
import com.example.hyundaiboot.service.UserDeviceService;
import com.example.hyundaiboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ApiController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserDeviceService userDeviceService;


	@GetMapping("/txt")
	public String getTest(@RequestParam String str){
		return str;
	}

	@GetMapping("/user")
	public User getUser(@RequestParam String id){
		Optional<User> userOptional;
		User user;
		try {
			user  = userService.getUserById(id);
		}catch (Exception e){
			user = new User();
			user.setId( "ttt");
			user.setName("test");
			user.setPw("123");
			user.setColor("blue");
			user.setFont("맑은");
			user.setLang("2");
		}
		return user;
	}

	@GetMapping("/devices")
	public List<UserDevice> getUserDevice(){
		return userDeviceService.getAllDevice();
	}

	@GetMapping("/device")
	public List<UserDevice> getUserDevice(@RequestParam String userid){
		List<UserDevice> userDevices;
		userDevices = userDeviceService.getDevices(userid);
		return userDevices;
	}
}
