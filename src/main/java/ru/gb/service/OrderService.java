package ru.gb.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.OrderDao;
import ru.gb.entity.Order;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderDao orderDao;

    public long count(){
        return orderDao.count();
    }

    public Order save(Order order) {
        return orderDao.save(order);
    }

    @Transactional(readOnly = true)
    public Order findById (Long id){
        return orderDao.findById(id).get();
    }

}
