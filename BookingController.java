package com.unza.club.club_management.controllers;

import com.unza.club.club_management.models.Room;
import com.unza.club.club_management.models.Equipment;
import com.unza.club.club_management.repositories.RoomRepository;
import com.unza.club.club_management.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/book-room")
    public String showRoomBookingForm(Model model) {
        List<Room> availableRooms = roomRepository.findByAvailability(true);
        model.addAttribute("availableRooms", availableRooms);
        model.addAttribute("bookingError", null);
        return "book-room";
    }

    @PostMapping("/book-room")
    public String processRoomBooking(@RequestParam("roomName") String roomName, Model model) {
        
        Room roomToBook = roomRepository.findByRoomNameAndAvailability(roomName, true);

        if (roomToBook != null) {
            roomToBook.setAvailability(false);
            roomRepository.save(roomToBook);
            return "redirect:/student-dashboard"; 
        } else {
            List<Room> availableRooms = roomRepository.findByAvailability(true);
            model.addAttribute("availableRooms", availableRooms);
            model.addAttribute("bookingError", "Sorry, this room has just been booked. Please choose another.");
            return "book-room";
        }
    }

    @GetMapping("/book-equipment")
    public String showEquipmentBookingForm(Model model) {
        List<Equipment> availableEquipment = equipmentRepository.findAll();
        model.addAttribute("availableEquipment", availableEquipment);
        model.addAttribute("equipmentError", null);
        return "book-equipment";
    }

    @PostMapping("/book-equipment")
    public String processEquipmentBooking(@RequestParam("equipmentName") String equipmentName, 
                                        @RequestParam("quantity") int quantity, 
                                        Model model) {
        
        Equipment equipment = equipmentRepository.findByEquipmentName(equipmentName);

        if (equipment != null && equipment.getTotalEquipment() >= quantity) {
            equipment.setTotalEquipment(equipment.getTotalEquipment() - quantity);
            equipmentRepository.save(equipment);
            return "redirect:/student-dashboard"; 
        } else {
            model.addAttribute("equipmentError", "Sorry, not enough " + equipmentName + " is available.");
            model.addAttribute("availableEquipment", equipmentRepository.findAll());
            return "book-equipment";
        }
    }
}