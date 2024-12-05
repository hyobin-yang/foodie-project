package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreCommandService {
    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewPage(Long storeId, Integer page);

    void validateStoreExistence(Long storeId);
}
