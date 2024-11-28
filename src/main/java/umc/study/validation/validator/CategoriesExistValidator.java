package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryErrorHandler;
import umc.study.repository.memberRepository.FoodCategoryRepository;
import umc.study.service.memberService.MemberCommandService;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

@Component
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final MemberCommandService memberCommandService;

    public CategoriesExistValidator(MemberCommandService memberCommandService){
        this.memberCommandService = memberCommandService;
    }

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        try{
            memberCommandService.validateFoodCategories(values);
            return true;
        } catch (FoodCategoryErrorHandler e){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;
        }
    }
}
