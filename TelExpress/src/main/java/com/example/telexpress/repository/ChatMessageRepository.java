package com.example.telexpress.repository;

import com.example.telexpress.entity.ChatMessage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer>, ChatMessageRepositoryCustom {
    @Query("SELECT cm FROM ChatMessage cm WHERE cm.destinationuser = :destinationuser ORDER BY cm.id DESC")
    ChatMessage getLastMessageByDestination(@Param("destinationuser") Integer destinationuser);
}
