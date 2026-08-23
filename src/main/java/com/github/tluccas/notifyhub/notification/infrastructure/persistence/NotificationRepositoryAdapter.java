package com.github.tluccas.notifyhub.notification.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.tluccas.notifyhub.notification.domain.model.Notification;
import com.github.tluccas.notifyhub.notification.domain.repository.NotificationRepository;

@Repository
public class NotificationRepositoryAdapter implements NotificationRepository {

    @Override
    public Notification save(Notification notification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Notification> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
