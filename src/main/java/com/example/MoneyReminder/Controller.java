package com.example.MoneyReminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    public Service service;

    @Autowired
    private FriendRepository friendRepository;

    Friend friend = new Friend("Name","Email");


    @GetMapping("/Money")
    public String hello(@RequestParam(value = "name", defaultValue = "Reminder") String name) {
        return String.format("Money %s!", name);

    }

    @GetMapping(path="/friend")
    public String friend() {
        return "Hello";
    }

    //@GetMapping("/allfriends")
   // public List<Friend> allFriends(){
     //   return (List<Friend>) friendRepository.findAll();
   // }

    @GetMapping("/friend/{name}")
    public String pathParams(@PathVariable("name")  String name){
        Friend friend1 = null;
        for (Friend friend: service.allFriends){
            if (name== friend.getName()){
                friend1 = new Friend (friend.getName(), friend.getEmail());
            }
        }
        return String.format("This is your Friend %s and his/her Email: %S", friend1.getName(), friend1.getEmail());
    }
    @GetMapping("/friends/debt")
    public List<String> friendsWithDebt(){
        var friendWithDebt = new ArrayList<String>();
        for (Friend friend : service.allFriends){
            if (friend.getOwes() == 0){
                friendWithDebt.add(friend.getName());
            }
        }
        return friendWithDebt;
    }

}
