CREATE TYPE notification_status AS ENUM ('SENT', 'PENDING', 'PROCESSING', 'FAILED');

CREATE TABLE notification (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    channelId UUID NOT NULL,
    recipient VARCHAR(512) NOT NULL,
    status notification_status DEFAULT 'PENDING',
    processingAt TIMESTAMP,
    createdAt TIMESTAMP DEFAULT now(),
    sentAt TIMESTAMP,
    failedAt TIMESTAMP,
    retryCount INT DEFAULT 0,
    lastError VARCHAR(512),
    CONSTRAINT fk_notification_channel FOREIGN KEY (channelId) REFERENCES channel(id) ON DELETE CASCADE,
);

CREATE TABLE notification_content (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    notificationId UUID NOT NULL,
    subject VARCHAR(512) NOT NULL,
    body TEXT NOT NULL,
    variables JSONB,
    createdAt TIMESTAMP DEFAULT now(),
    CONSTRAINT fk_notification_content_notification FOREIGN KEY (notificationId) REFERENCES notification(id) ON DELETE CASCADE,
);