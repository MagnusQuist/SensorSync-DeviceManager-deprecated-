package dk.sdu.mmmi.DeviceManager.controller;

import dk.sdu.mmmi.DeviceManager.entity.Device;
import dk.sdu.mmmi.DeviceManager.repository.IDeviceRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class DeviceController {

    private final IDeviceRepository deviceRepository;

    public DeviceController(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    @GetMapping(path = "/devices")
    public Iterable<Device> getAllDevices() {
        return this.deviceRepository.findAll();
    }

    @PostMapping(path = "/devices")
    public Device addDevice(@RequestBody Device device) {
        System.out.println("Get create request");
        return this.deviceRepository.save(device);
    }
}
