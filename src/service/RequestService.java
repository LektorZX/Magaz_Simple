package service;

import DTO.RequestDtoUser;
import dao.BacketDao;
import dao.ProductDao;
import dao.UserDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.*;

import java.util.Set;
//взяли данные из сервлета и перенесли в модель,потом вызвали сейв в дао модели

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestService {

    private static final RequestService INSTANCE = new RequestService();

    public User save(RequestDtoUser requestDto) {
        User request = User.builder()
                .name(requestDto.getName())
                .mail(requestDto.getMail())
                .id(requestDto.getId())
                .status(Status.getIntToStringStatus(requestDto.getStatus()))
                .build();
        return UserDao.getInstance().CreateUser(request);
    }

    public boolean saveOrder(String[] dtoBacket,Integer idUser) {
       // в ордере список товаров,в корзине id покупателя+++++++++++++++

        Basket basket=Basket.builder()
                .idUser(idUser)
                .build();
        Set<Product>products=ProductDao.getInstance().SearchProduct(dtoBacket);
        Order order=Order.builder()
                .products(products)
                .build();

        return BacketDao.getInstance().setCreateOrder(basket,order);
    }




    public static RequestService getInstance() {
        return INSTANCE;
    }
}
