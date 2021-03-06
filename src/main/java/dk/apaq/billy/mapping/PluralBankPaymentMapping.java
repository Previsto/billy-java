package dk.apaq.billy.mapping;

import dk.apaq.billy.model.BankPayment;
import org.springframework.data.domain.Page;

import java.util.List;

public class PluralBankPaymentMapping extends BankPaymentMapping implements PluralMapping<BankPayment>{
    private List<BankPayment> bankPayments;

    public List<BankPayment> getBankPayments() {
        return bankPayments;
    }

    public void setBankPayments(List<BankPayment> BankPayments) {
        this.bankPayments = BankPayments;
    }

    @Override
    public Page<BankPayment> getPage() {
        bankPayments.forEach(c -> resolveExtraData(c));
        return resolvePage(getMeta(), bankPayments);
    }
    
}
