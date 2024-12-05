package umc.study.service.reviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberErrorHandler;
import umc.study.apiPayload.exception.handler.StoreErrorHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.repository.reviewRepository.ReviewRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinDto request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreErrorHandler(ErrorStatus.STORE_NOT_FOUND));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, store, member);
        return reviewRepository.save(newReview);
    }
}
