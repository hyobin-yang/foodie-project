package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class StoreErrorHandler extends GeneralException {
    public StoreErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
