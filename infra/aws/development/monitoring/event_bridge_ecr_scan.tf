resource "aws_cloudwatch_event_rule" "ecr_scan_event" {
  name          = "ecr-scan-event"
  description   = "triggered when image scan was completed."
  event_pattern = file("./event_pattern/ecr_scan.json")
}

resource "aws_cloudwatch_event_target" "sns" {
  rule = aws_cloudwatch_event_rule.ecr_scan_event.name
  arn  = aws_sns_topic.ecr_scan_event.arn
}
