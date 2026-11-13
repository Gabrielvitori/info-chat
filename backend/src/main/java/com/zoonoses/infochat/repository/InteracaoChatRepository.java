package com.zoonoses.infochat.repository;

import com.zoonoses.infochat.entity.InteracaoChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteracaoChatRepository extends JpaRepository<InteracaoChat, Long> {
}