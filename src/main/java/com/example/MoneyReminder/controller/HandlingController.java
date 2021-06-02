package com.example.MoneyReminder.controller;

import com.example.MoneyReminder.Friend;
import com.example.MoneyReminder.FriendRepository;
import com.example.MoneyReminder.Service;
import com.example.MoneyReminder.config.Endpoints;
import com.example.MoneyReminder.config.ViewNames;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HandlingController {
    public Service service;


    private FriendRepository friendRepository;
    private Object Friend;

    public HandlingController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @RequestMapping(path = "/createfriend")
    public String createFriend(@ModelAttribute("friend") com.example.MoneyReminder.Friend friend, Model model){
        friendRepository.save(friend);
        model.addAttribute("friend", friend);
        return "createfriend";
    }


    @GetMapping("/allfriends")
    public String allFriends(Model model){
        List<Friend> allFriends = (List<Friend>) friendRepository.findAll();
        model.addAttribute("allFriends", allFriends);
        return "allfriends";
    }

    @GetMapping("/home")
    public String home(Model model){
        List<Friend> allFriends = (List<Friend>) friendRepository.findAll();
        model.addAttribute("allFriends", allFriends);
        return "home";
    }

    @GetMapping("/creationresult")
    public String creationResult(Model model){
        List<Friend> allFriends = (List<Friend>) friendRepository.findAll();
        model.addAttribute("allFriends", allFriends);
        return "creationist";
    }

    @GetMapping(value = {Endpoints.Site.LOGIN, Endpoints.Site.REMINDER})
        public ModelAndView getCurrentUser(@AuthenticationPrincipal OidcUser user) {
            Map<String, String> viewModel = new HashMap<>();
            if (user != null) {
                viewModel.put("name", user.getGivenName() + " " + user.getFamilyName());
            }
            return new ModelAndView(ViewNames.LOGIN, viewModel);
        }
    }

