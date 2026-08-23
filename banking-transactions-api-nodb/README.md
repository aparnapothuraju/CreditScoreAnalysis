# Banking Transactions API (No Database)

Same API as `banking-transactions-api`, but with **zero database
dependency** — no MySQL, no JPA, no connection strings. All 22
transactions from `credit_score_dummy_data.sql` are hardcoded into an
in-memory store (`BankingTransactionDataStore`), rebuilt fresh every
time the app starts.

Use this version if you just want to run the "internal data source"
side locally without setting up MySQL first — same endpoints, same
data, same JSON shape as the database-backed version.

## Run it

```bash
mvn spring-boot:run
```

Runs on **port 9091**. No setup steps beyond this — no `CREATE DATABASE`,
no seed script to run first.

## Endpoints

### Get all transactions for a user (most recent first)
```bash
curl http://localhost:9091/api/transactions/user/1
```

### Filter by type
```bash
curl http://localhost:9091/api/transactions/user/1/type/DEBIT
```

### Unknown user → 404
```bash
curl http://localhost:9091/api/transactions/user/99
```

### Health check
```bash
curl http://localhost:9091/api/transactions/health
```

## When to switch back to the database-backed version

This in-memory version is great for quick local testing, but data
resets every restart and there's only ever these 10 fixed users. Once
you want to actually add/update transactions, or test against real
persisted data, switch to `banking-transactions-api` (the JPA + MySQL
version) instead — same API contract, so your Data Collection Service
code doesn't need to change either way.
