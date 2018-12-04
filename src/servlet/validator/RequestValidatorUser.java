package servlet.validator;

import DTO.RequestDtoUser;
import static util.StringUtil.isEmpty;

public class RequestValidatorUser implements Validator<RequestDtoUser> {

    @Override
    public boolean isValid(RequestDtoUser object) {
        return !isEmpty(object.getName()) && !isEmpty(object.getMail());
    }
}
