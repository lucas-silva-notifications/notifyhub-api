CREATE TYPE channel_type AS ENUM ('EMAIL', 'SMS');

CREATE TABLE channel (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    type channel_type NOT NULL,
    active BOOLEAN DEFAULT true,
    createdAt TIMESTAMP DEFAULT now(),
);

CREATE TABLE email_channel_config (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    channelId UUID NOT NULL,
    host VARCHAR(512) NOT NULL,
    port INT NOT NULL,
    username VARCHAR(512) NOT NULL,
    password VARCHAR(512),
    createdAt TIMESTAMP DEFAULT now(),
    CONSTRAINT fk_email_channel_config_channel FOREIGN KEY (channelId) REFERENCES channel(id) ON DELETE CASCADE,
);