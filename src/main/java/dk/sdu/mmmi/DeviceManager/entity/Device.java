package dk.sdu.mmmi.DeviceManager.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String firmware_version;
    private String athena_version;
    @Column(unique=true)
    private UUID device_id;

    public Device() {}

    public Device(String name, String firmware_version, String athena_version, UUID device_id) {
        this.name = name;
        this.firmware_version = firmware_version;
        this.athena_version = athena_version;
        this.device_id = device_id;
    }

    public String getName() {
        return name;
    }

    public String getFirmware_version() {
        return firmware_version;
    }

    public String getAthena_version() {
        return athena_version;
    }
    public UUID getDevice_id() {
        return device_id;
    }
}
