package com.example.hairbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @Autowired
    private ClientDAO clientDAO;

    @GetMapping("/clients")
    public String getClients(Model model) {
        model.addAttribute("clients", clientDAO.getAllClients());
        return "clients";
    }

    @PostMapping("/addClient")
    public String addClient(@RequestParam String name,
                            @RequestParam String hairService,
                            @RequestParam String appointmentDate,
                            @RequestParam String phoneNumber,
                            @RequestParam String address) {
        Client client = new Client();
        client.setName(name);
        client.setHairService(hairService);
        client.setAppointmentDate(appointmentDate);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);
        clientDAO.addClient(client);
        return "redirect:/clients";
    }
}
