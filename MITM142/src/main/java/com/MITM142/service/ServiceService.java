package com.MITM142.service;

import com.MITM142.data.ServiceView;
import com.MITM142.exception.BadRequestException;
import com.MITM142.exception.GeneralException;
import com.MITM142.repository.ServiceRepository;
import com.MITM142.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.MITM142.mapper.ViewMapper.mapToServiceView;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;

    // List with all available orders, except the ones created by logged user
    public List<ServiceView> getServiceList(Integer userId) {
        return mapToServiceView(getServices(userId), userRepository.findAllUsers());
    }

    // List with personal orders for logged user
    public List<com.MITM142.data.Service> getPersonalServiceList(Integer userId) {
        return serviceRepository.findServicesByUserId(userId);
    }

    public void saveService(com.MITM142.data.Service service) {
        if (Objects.equals(service.getType(), "") || service.getPrice() == null ||
                service.getTimeInHours() == null || Objects.equals(service.getShortDescription(), "") ||
                Objects.equals(service.getLongDescription(), "")) {
            throw new BadRequestException("Empty values are not allowed");
        }
        try {
            serviceRepository.createService(service);
        } catch (Exception exception) {
            throw new GeneralException("An error has occurred, the provided data was not registered");
        }

    }

    public List<String> getTypes() {
        return List.of(
                "Excavation",
                "Concrete pouring",
                "Bricklaying",
                "Masonry",
                "Steel reinforcement",
                "Roofing",
                "Plumbing",
                "Electrical installation",
                "Carpentry",
                "Painting",
                "Tiling",
                "Drywall installation",
                "Insulation",
                "Window installation",
                "Flooring",
                "Landscaping",
                "Foundation work",
                "Wall framing",
                "Ceiling installation",
                "HVAC installation",
                "Site clearing",
                "Paving",
                "Sewer system installation",
                "Structural welding",
                "Foundation waterproofing"
        );
    }

    public List<com.MITM142.data.Service> getServices(Integer userId) {
        var serviceList = serviceRepository.findAllServices();

        return serviceList.stream()
                .filter(service -> !service.getUserId().equals(userId))
                .toList();
    }
}
