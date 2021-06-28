package com.example.MoneyReminder.controller;

import com.example.MoneyReminder.Friend;
import com.example.MoneyReminder.FriendRepository;
import com.example.MoneyReminder.Service;
import com.example.MoneyReminder.config.Endpoints;
import com.example.MoneyReminder.config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    public Service service;


    @Autowired
    private FriendRepository friendRepository;

    Friend friend = new Friend("Name", "Email");


    @PostMapping("/rest/friends")
    public Friend createFriend(@RequestBody Friend friend) {
        return friendRepository.save(friend);
    }


}

