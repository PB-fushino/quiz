## 研修用 SpringBootプロジェクト

### SpringBootの起動準備
1. DBを立ち上げます  
1. documents/db/ddl.sqlの内容を実行します
1. Eclipseを起動します
1. インポート画面で既存のMavenプロジェクトを選択し、appディレクトリ直下を指定してインポートします
1. フォーマッターの設定をします
    * [フォーマッタの設定方法](https://dev-plan-b.atlassian.net/wiki/spaces/DEV/pages/303923576/eclipse)
1. 静的コード解析(SpotBugs)の設定をします
    * [静的コード解析の設定方法](https://dev-plan-b.atlassian.net/wiki/spaces/DEV/pages/304054528/-+spotBugs+-+eclipse) ※SpotBugsプラグインの自動実行化から設定をお願いします

    
1. resourcesディレクトリの中にあるapplication.propertiesに以下の内容を入力してください。

    * spring.datasource.driver-class-name　=> ドライバー名
    * spring.datasource.url => 接続先URL
    * spring.datasource.username => ユーザー名
    * spring.datasource.password => パスワード

1. SpringBootを起動します