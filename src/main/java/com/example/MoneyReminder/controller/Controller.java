package com.example.MoneyReminder.controller;

import com.example.MoneyReminder.Friend;
import com.example.MoneyReminder.FriendRepository;
import com.example.MoneyReminder.Service;
import com.example.MoneyReminder.config.Endpoints;
import com.example.MoneyReminder.config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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


    @GetMapping(path = "/friend")
    public String friend() {
        return "Hello";
    }

    //@GetMapping("/allfriends")
    // public List<Friend> allFriends(){
    //   return (List<Friend>) friendRepository.findAll();
    // }

    @GetMapping("/friend/{name}")
    public String pathParams(@PathVariable("name") String name) {
        Friend friend1 = null;
        for (Friend friend : service.allFriends) {
            if (name == friend.getName()) {
                friend1 = new Friend(friend.getName(), friend.getEmail());
            }
        }
        return String.format("This is your Friend %s and his/her Email: %S", friend1.getName(), friend1.getEmail());
    }

    @GetMapping("/friends/debt")
    public List<String> friendsWithDebt() {
        var friendWithDebt = new ArrayList<String>();
        for (Friend friend : service.allFriends) {
            if (friend.getOwes() == 0) {
                friendWithDebt.add(friend.getName());
            }
        }
        return friendWithDebt;
    }
}

