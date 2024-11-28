package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class FoodCategoryErrorHandler extends GeneralException {
    public FoodCategoryErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
