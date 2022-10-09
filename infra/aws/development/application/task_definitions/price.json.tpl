[{
    "name": "railway_pricing",
    "image": "${aws_account_id}.dkr.ecr.ap-northeast-1.amazonaws.com/railway_pricing:0.1.0",
    "portMappings": [{
        "containerPort": 8080,
        "hostPort": 8080
    }],
    "logConfiguration": {
      "logDriver": "awslogs",
      "options": {
        "awslogs-region": "ap-northeast-1",
        "awslogs-group": "railway-price-calculation-cluster-log-group",
        "awslogs-stream-prefix": "railway-pricing-container-log-stream"
      }
    },
    "secrets": [{
            "name": "SPRING_DATASOURCE_USERNAME",
            "valueFrom": "${database_username}"
        },
        {
            "name": "SPRING_DATASOURCE_PASSWORD",
            "valueFrom": "${database_password}"
        },
        {
            "name": "SPRING_DATASOURCE_URL",
            "valueFrom": "${database_endpoint}"
        }
    ]
}]
