package ru.gb.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.ManufacturerDao;
import ru.gb.entity.Manufacturer;

@Service
@RequiredArgsConstructor
@Transactional
public class ManufacturerService {
    private final ManufacturerDao manufacturerDao;

    public long count(){
        return manufacturerDao.count();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerDao.save(manufacturer);
    }

    @Transactional(readOnly = true)
    public Manufacturer findById (Long id){
        return manufacturerDao.findById(id).get();
    }
}
