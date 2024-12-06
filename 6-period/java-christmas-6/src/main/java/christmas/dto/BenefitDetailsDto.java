package christmas.dto;

import java.util.Collections;
import java.util.List;

public class BenefitDetailsDto {
    private final List<BenefitDetail> benefitDetails;

    public BenefitDetailsDto(final List<BenefitDetail> benefitDetails) {
        this.benefitDetails = benefitDetails;
    }

    public boolean isNothing() {
        return benefitDetails.size() == 0;
    }

    public List<BenefitDetail> getBenefitDetails() {
        return Collections.unmodifiableList(benefitDetails);
    }
}
