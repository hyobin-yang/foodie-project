package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class MemberErrorHandler extends GeneralException {
    public MemberErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
