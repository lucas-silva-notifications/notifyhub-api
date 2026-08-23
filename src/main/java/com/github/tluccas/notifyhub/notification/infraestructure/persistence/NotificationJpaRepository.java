package com.github.tluccas.notifyhub.notification.infraestructure.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.tluccas.notifyhub.notification.domain.model.Notification;

public interface NotificationJpaRepository extends JpaRepository<Notification, UUID> {}
