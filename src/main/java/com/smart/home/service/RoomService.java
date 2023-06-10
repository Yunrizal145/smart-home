package com.smart.home.service;

import com.smart.home.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();
    Room createRoom(Room room);
}
