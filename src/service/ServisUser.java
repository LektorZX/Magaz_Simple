package service;

import DTO.RequestDtoUser;
import dao.UserDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Status;
import model.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServisUser {
    private static final ServisUser INSTANCE = new ServisUser();


    public static ServisUser getInstance() {
        return INSTANCE;
    }
    //проверяем есть ли юзер
    public User Direct(RequestDtoUser requestDto) {
        User request = User.builder()
                .name(requestDto.getName())
                .mail(requestDto.getMail())
                .status(Status.getIntToStringStatus(requestDto.getStatus()))
                .build();
        return UserDao.getInstance().SearchUser(request);
    }
}
