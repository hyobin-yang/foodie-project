package umc.study.service.StoreService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreErrorHandler;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.reviewRepository.ReviewRepository;
import umc.study.repository.storeRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        filteredStores.forEach(store -> System.out.println("Store: " + store));
        return filteredStores;
    }

    @Override
    public Page<Review> getReviewPage(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();
        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public void validateStoreExistence(Long id){
        if (!storeRepository.existsById(id)){
            throw new StoreErrorHandler(ErrorStatus.STORE_NOT_FOUND);
        }
    }

}
