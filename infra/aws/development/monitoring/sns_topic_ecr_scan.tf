resource "aws_sns_topic" "ecr_scan_event" {
  name = "ecr-scan-event"
}

resource "aws_sns_topic_policy" "default" {
  arn    = aws_sns_topic.ecr_scan_event.arn
  policy = data.aws_iam_policy_document.this.json
}

resource "aws_sns_topic_subscription" "email" {
  topic_arn = aws_sns_topic.ecr_scan_event.arn
  protocol  = "email"
  endpoint  = "uesugi.4lu.kirari@gmail.com"
}
