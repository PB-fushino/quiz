package jp.co.plan_b.training.presentation.response;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component("PresentationResponseHeader")
public class ResponseHeader {

  private String origin = "*";

  public ResponseHeader() {}

  /**
   * GETリクエスト用のレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getStandardGetHeader() {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "GET,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }

  /**
   * GETリクエスト用のレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getStandardGetHeader(String trackingId) {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "GET,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    headers.add("X-Tracking", trackingId);
    return headers;
  }

  /**
   * GETリクエスト用のCSVレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getCsvGetHeader() {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "GET,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "text/csv; charset=shift-jis");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }

  /**
   * GETリクエスト用のCSVレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getCsvGetHeader(String trackingId) {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "GET,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "text/csv; charset=shift-jis");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    headers.add("X-Tracking", trackingId);
    return headers;
  }

  /**
   * POSTリクエスト用のレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getStandardPostHeader() {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "POST,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }

  /**
   * POSTリクエスト用のレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getStandardPostHeader(String trackingId) {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "POST,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    headers.add("X-Tracking", trackingId);
    return headers;
  }

  /**
   * DELETEリクエスト用のレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getStandardDeleteHeader() {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "DELETE,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }

  public HttpHeaders getStandardDeleteHeader(String trackingId) {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    headers.add("X-Tracking", trackingId);
    return headers;
  }

  /**
   * <<<<<<< HEAD PUTリクエスト用のレスポンスヘッダー作成処理
   *
   * @return HttpHeaders
   */
  public HttpHeaders getStandardPutHeader() {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "PUT,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-Authorization, X-From, Authorization, Content-Type");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }

  public HttpHeaders getStandardFullHeader() {
    // ヘッダー作成
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", origin);
    headers.add("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
    headers.add("Access-Control-Allow-Headers",
        "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }
}
