package umc.study.service.reviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.reviewRepository.ReviewRepository;
import umc.study.repository.storeRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(Long storeId, String content) {
        // Store 조회
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));

        // Review 생성
        Review review = Review.builder()
                .content(content)
                .store(store)
                .build();

        // Review 저장
        return reviewRepository.save(review);
    }
}
