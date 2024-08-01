package com.example.SQLiteDemo.controller;

import com.example.Client;
import com.example.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientDAO clientDAO;

    @GetMapping("/")
    public String showClientManagement(Model model) {
        List<Client> clients = clientDAO.getAllClients();
        model.addAttribute("clients", clients);
        return "index"; // Ensure that index.html exists in the templates directory
    }

    @PostMapping("/addClient")
    public String addClient(
            @RequestParam String name,
            @RequestParam String hairService,
            @RequestParam String appointmentDate,
            @RequestParam String phoneNumber,
            @RequestParam String address,
            Model model) {
        Client client = new Client(name, hairService, appointmentDate, phoneNumber, address);
        clientDAO.addClient(client);
        return "redirect:/"; // Redirect to the home page to show updated client list
    }
}

