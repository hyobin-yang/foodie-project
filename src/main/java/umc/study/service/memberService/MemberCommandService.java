package umc.study.service.memberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
    void validateFoodCategories(List<Long> values);
}
