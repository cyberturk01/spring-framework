package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
