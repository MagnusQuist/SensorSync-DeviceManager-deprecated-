package dk.sdu.mmmi.DeviceManager.repository;

import dk.sdu.mmmi.DeviceManager.entity.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceRepository extends CrudRepository<Device, Integer> {}
