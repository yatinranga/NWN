package com.example.NWM.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NWM.entity.Card;
import com.example.NWM.view.CardResponse;

@Repository
public interface CardJpaDao extends JpaRepository<Card, Long> {

	CardResponse findByNumber(String number);

	// @Query(value = "select nwn.card.number from Card where card.id =?1",
	// nativeQuery = true)
	CardResponse findByIdAndActiveTrue(Long id);

}
