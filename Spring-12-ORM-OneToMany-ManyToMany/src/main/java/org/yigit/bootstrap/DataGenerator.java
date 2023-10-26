package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.enums.Status;
import org.yigit.model.Merchant;
import org.yigit.model.Payment;
import org.yigit.model.PaymentDetail;
import org.yigit.repository.MerchantRepository;
import org.yigit.repository.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(new BigDecimal(15000), LocalDate.of(2023, 4, 19), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal(14000), new BigDecimal(10000), LocalDate.of(2023, 4, 24));
        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(new BigDecimal(10000), LocalDate.of(2023, 4, 25), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal(9000), new BigDecimal(5000), LocalDate.of(2023, 4, 29));
        payment2.setPaymentDetail(paymentDetail2);
        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123", new BigDecimal("0.25"), new BigDecimal("3.25"), 25);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        merchantRepository.save(merchant1);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}
