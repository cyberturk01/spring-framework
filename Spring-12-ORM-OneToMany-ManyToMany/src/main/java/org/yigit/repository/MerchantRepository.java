package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
