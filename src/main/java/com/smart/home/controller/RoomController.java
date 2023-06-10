package com.smart.home.controller;

import com.smart.home.model.Room;
import com.smart.home.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }


    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }
}
