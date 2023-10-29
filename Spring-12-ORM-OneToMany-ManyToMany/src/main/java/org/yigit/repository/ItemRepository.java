package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
