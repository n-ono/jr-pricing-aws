# jr-pricing-aws

個人学習で AWS に DDD の課題である [鉄道料金計算](https://github.com/masuda220/jr-pricing) システムを構築した

## バージョン

- Java11
- SpringBoot 2.6.2

## システム構成

- [ドメインモデル](./doc/model/model.md)
- [AWS](./doc/aws/aws.md)

## 実行方法

1. 本リポジトリを clone する

   ```
   git clone https://github.com/n-ono/jr-pricing-aws.git
   ```

2. ディレクトリを移動する

   ```
   cd jr-pricing-aws
   ```

3. war を作成する

   ```
   ./gradlew clean bootWar
   ```

4. コンテナイメージを build する

   ```
   docker build -t railway_pricing -f infra/docker/app/Dockerfile .
   ```

5. DB への接続情報を記載したファイル ( `.env` ) を `infra/docker/` に作成する

   ```
   POSTGRES_USER=catalogue
   POSTGRES_PASSWORD=catalogue
   POSTGRES_DB=catalogue
   ```

6. コンテナを起動する

   ```
   docker-compose -f infra/docker/docker-compose.yml up -d
   ```

## curl コマンドサンプル

```
curl -v -G -d train-type=hikari -d seat-type=reserved -d destination=himeji -d trip-type=round -d children=1 -d adults=2 -d departure-date=20200904 http://localhost:8080/railway_pricing/calculate-price
```

各クエリパラメータの意味と設定値は以下の通り

| クエリパラメータ | 意味 | 設定値 |
| -- | -- | -- |
| train-type | 利用する列車 ( ひかり or のぞみ ) | hikari / nozomi |
| seat-type | 利用する座席 ( 自由席 or 指定席 ) | free / reserved |
| destination | 目的地 ( 新大阪 or 姫路 ) | shinosaka / himeji |
| trip-type | 旅行の種類 ( 片道 or 往復 ) | one-way / round |
| children | 子供の人数 | 0 以上の整数 |
| adults | 大人の人数 | 0 以上の整数 |
| departure-date | 出発日 | yyyymmdd の形式 |