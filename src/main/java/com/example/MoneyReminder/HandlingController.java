package com.example.MoneyReminder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HandlingController {
    public Service service;


    private FriendRepository friendRepository;

    public HandlingController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

   // @PostMapping(path= "/createfriend")
   // public String createFriend(@ModelAttribute Model model, Friend friend){
     //   friendRepository.save(friend);
       // model.addAttribute("friend", friend);
    //    return "creationresult";
    //}
    @PostMapping(path ="/createfriend")
    public RedirectView handleRegistrationRequest(Friend friend) {
        friendRepository.save(friend);
        return new RedirectView("/createfriend");
    }

    @ModelAttribute(name = "friend")
    public Friend friend() {
        return new Friend();
    }

    @GetMapping("/allfriends")
    public String allFriends(Model model){
        List<Friend> allFriends = (List<Friend>) friendRepository.findAll();
        model.addAttribute("allFriends", allFriends);
        return "allfriends";
    }

}
