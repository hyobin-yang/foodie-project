package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float score;
        @NotNull
        Long storeId;
        @NotNull
        Long memberId;
    }
}
