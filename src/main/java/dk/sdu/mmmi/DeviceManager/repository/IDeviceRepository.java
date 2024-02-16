package dk.sdu.mmmi.DeviceManager.repository;

import dk.sdu.mmmi.DeviceManager.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDeviceRepository extends CrudRepository<Device, Long> {
    @Query("SELECT d FROM Device d WHERE d.device_id = :deviceId")
    Optional<Device> findByDeviceId(@Param("deviceId") UUID deviceId);
}
