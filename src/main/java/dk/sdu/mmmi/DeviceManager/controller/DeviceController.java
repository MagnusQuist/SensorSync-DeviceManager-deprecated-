package dk.sdu.mmmi.DeviceManager.controller;

import dk.sdu.mmmi.DeviceManager.entity.Device;
import dk.sdu.mmmi.DeviceManager.repository.IDeviceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<?> addDevice(@RequestBody Device device) {
        System.out.println("Received create request");
        Optional<Device> existingDevice = deviceRepository.findByDeviceId(device.getDevice_id());
        if (existingDevice.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Device with UUID " + device.getDevice_id() + " already exists");
        }

        Device savedDevice = deviceRepository.save(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDevice);
    }
}
