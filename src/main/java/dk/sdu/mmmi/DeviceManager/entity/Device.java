package dk.sdu.mmmi.DeviceManager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String firmware_version;
    private String athena_version;

    public Device() {}

    public Device(String name, String firmware_version, String athena_version) {
        this.name = name;
        this.firmware_version = firmware_version;
        this.athena_version = athena_version;
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
}
