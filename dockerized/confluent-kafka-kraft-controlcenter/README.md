# Confluent Kafka with Kraft and Control Center

This project sets up a Confluent Kafka environment using Kraft (Kafka Raft Metadata mode) along with the Control Center for monitoring and managing Kafka clusters.

## Project Structure

```
confluent-kafka-kraft-controlcenter
├── docker-compose.yaml       # Defines the services for Kafka and Control Center
├── config                    # Configuration files for Kafka and Control Center
│   ├── kafka.properties      # Kafka broker configuration
│   └── control-center.properties # Control Center configuration
└── README.md                 # Project documentation
```

## Prerequisites

- Docker and Docker Compose installed on your machine.

## Setup Instructions

1. Clone this repository to your local machine.
2. Navigate to the project directory:
   ```
   cd confluent-kafka-kraft-controlcenter
   ```
3. Start the services using Docker Compose:
   ```
   docker-compose up -d
   ```

## Usage Guidelines

- Access the Control Center at `http://localhost:9021`.
- Use the Kafka broker at `localhost:9092` for producing and consuming messages.

## Configuration

- Modify `config/kafka.properties` to change Kafka broker settings.
- Modify `config/control-center.properties` to change Control Center settings.

## Stopping the Services

To stop the services, run:
```
docker-compose down
```

## Additional Information

Refer to the official Confluent documentation for more details on Kafka and Control Center configurations and best practices.