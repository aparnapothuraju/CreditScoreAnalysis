# Mock Credit Bureau API

A standalone, runnable Spring Boot app that simulates the "third-party
credit bureau" system referenced in your Credit Score Analysis Tool
architecture. Use this as the target of your Data Collection Service's
outbound external-API call.

## Run it

```bash
mvn spring-boot:run
```

Starts on **port 9090** (separate from your other services, which use 8080).

## Endpoints

### Get a credit report
```
GET http://localhost:9090/v1/credit-report/{userId}
Header: X-Api-Key: any-value-you-like
```

Example:
```bash
curl -H "X-Api-Key: test123" http://localhost:9090/v1/credit-report/1
```

Response:
```json
{
  "userId": 1,
  "bureauScore": 740,
  "existingLoansCount": 1,
  "existingLoansTotal": 120000.00,
  "creditUtilizationPct": 22.50,
  "latePaymentsLastYear": 0,
  "defaultsCount": 0,
  "creditHistoryYears": 12,
  "reportDate": "2026-05-01",
  "bureauName": "FakeBureau Sweden AB"
}
```

Valid `userId` values: **1 through 10** (matches the dummy dataset from
`credit_score_dummy_data.sql`).

### Error cases (built in on purpose, so you can test your service's handling)
- **Missing `X-Api-Key` header** → `401 Unauthorized`
- **Unknown userId** (e.g. `99`) → `404 Not Found`
- Every successful call has **150-600ms simulated latency** — realistic
  enough to test timeouts/retries in your `WebClient` or Feign client.

### Health check
```bash
curl http://localhost:9090/v1/health
```

## Wiring it into your Data Collection Service

```yaml
# application.yaml in your usermanagmentservice / data-collection-service
credit-bureau:
  base-url: http://localhost:9090
  api-key: test123
```

```java
@Service
public class CreditBureauClient {

    private final WebClient webClient;

    public CreditBureauClient(WebClient.Builder builder,
                               @Value("${credit-bureau.base-url}") String baseUrl) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    public CreditBureauReportDTO fetchCreditData(int userId, String apiKey) {
        return webClient.get()
            .uri("/v1/credit-report/{userId}", userId)
            .header("X-Api-Key", apiKey)
            .retrieve()
            .bodyToMono(CreditBureauReportDTO.class)
            .block();
    }
}
```

## Notes
- All data is in-memory (`CreditBureauDataStore`) — no database needed for
  this mock service.
- Field names are deliberately shaped a bit differently from your internal
  `credit_bureau_data` SQL table (e.g. camelCase, `bureauScore` vs
  `bureau_score`), so your Data Collection Service has genuine
  normalization work to do — same as integrating with a real external
  bureau would require.
