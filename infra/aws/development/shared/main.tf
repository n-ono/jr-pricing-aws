terraform {
  # リリース情報: https://github.com/hashicorp/terraform/releases
  required_version = "1.3.2"
}

provider "aws" {
  region = "ap-northeast-1"
}

resource "aws_default_vpc" "default" {
}
