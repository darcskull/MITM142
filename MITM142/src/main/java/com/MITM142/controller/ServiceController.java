package com.MITM142.controller;

import com.MITM142.data.Service;
import com.MITM142.data.User;
import com.MITM142.service.ServiceService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    @GetMapping("/services")
    public String getServices(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        var services = service.getServiceList(user.getId());
        model.addAttribute("serviceView", services);
        return "services";
    }

    @GetMapping("/service/form")
    public String getServiceForm(Model model) {
        model.addAttribute("types", service.getTypes());
        return "serviceForm";
    }

    @GetMapping("/personal/services")
    public String getPersonalServices(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        var services = service.getPersonalServiceList(user.getId());
        model.addAttribute("personalServices", services);
        return "personalServices";
    }

    @PostMapping("/create/service")
    public ResponseEntity<Void> createService(HttpSession session, @RequestBody Map<String, String> request) {
        User user = (User) session.getAttribute("loggedInUser");
        var serviceData = new Service();
        serviceData.setUserId(user.getId());
        serviceData.setPrice(new BigDecimal(request.get("price")));
        serviceData.setType(request.get("type"));
        serviceData.setLongDescription(request.get("longDescription"));
        serviceData.setShortDescription(request.get("shortDescription"));
        serviceData.setTimeInHours(Integer.valueOf(request.get("timeInHours")));
        service.saveService(serviceData);
        return ResponseEntity.ok().build();
    }

}
