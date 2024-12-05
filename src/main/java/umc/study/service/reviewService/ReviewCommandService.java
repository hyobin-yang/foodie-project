package umc.study.service.reviewService;


import umc.study.domain.Review;

public interface ReviewCommandService {
    public Review joinReview(ReviewRequestDTO.JoinDto request);
}
