package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.exception.handler.StoreErrorHandler;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.validation.annotation.ExistStore;

@Component
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreCommandService storeCommandService;

    public StoreExistValidator(StoreCommandService storeCommandService){
        this.storeCommandService = storeCommandService;
    }

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        try{
            storeCommandService.validateStoreExistence(storeId);
            return true;
        } catch (StoreErrorHandler e){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;
        }

    }
}
