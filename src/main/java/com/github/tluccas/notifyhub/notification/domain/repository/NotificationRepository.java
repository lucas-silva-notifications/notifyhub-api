package com.github.tluccas.notifyhub.notification.domain.repository;

import java.util.Optional;

import com.github.tluccas.notifyhub.notification.domain.model.Notification;

public interface NotificationRepository {
    
    Notification save(Notification notification);

    Optional<Notification> findById(String id);
}
