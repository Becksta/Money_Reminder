package com.example.MoneyReminder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HandlingController {
    public Service service;


    private FriendRepository friendRepository;
    private Object Friend;

    public HandlingController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @RequestMapping(path = "/createfriend")
    public String createFriend(@ModelAttribute("friend") Friend friend, Model model){
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

   // @RequestMapping(value = "/save", method = RequestMethod.POST)
    //public String saveProduct(@ModelAttribute("friend") Friend friend) {
    //    friendRepository.save(friend);

     //   return "creationresult";
   // }

}
