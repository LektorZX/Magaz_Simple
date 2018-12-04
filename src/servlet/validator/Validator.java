package servlet.validator;

public interface Validator<T> {

    boolean isValid(T object);
}
