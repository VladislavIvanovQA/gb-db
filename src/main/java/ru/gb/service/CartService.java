package ru.gb.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.CartDao;
import ru.gb.entity.Cart;


@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final CartDao cartDao;

    public long count(){
        return cartDao.count();
    }

    public Cart save(Cart cart) {
        return cartDao.save(cart);
    }

    @Transactional(readOnly = true)
    public Cart findById (Long id){
        return cartDao.findById(id).get();
    }
}
