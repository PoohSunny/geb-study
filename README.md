geb-study
====================================

これは、[第１回Geb勉強会](http://geb.connpass.com/event/11030/)のプレゼンで利用する予定のサンプルコードです。

## 始め方

### gradle wrapperを利用する

このプロジェクトをcloneし、以下のコマンドを実行してください。

```bash
# Mac, Unixの場合
$ chmod +x gradlew
$ ./gradlew -v

# Windowsの場合
$ gradlew.bat -v
```

### プロジェクトファイルの作成
EclipseあるいはIntelliJ IDEAで利用したい場合は、下記コマンドを実行し、プロジェクトをインポートしてください。

```bash
# Eclipseの場合
$ ./gradlew eclipse

# IntelliJ IDEAの場合
$ ./gradlew idea
```

## 動かし方

### ブラウザを指定して実行
以下のコマンドを実行すると、それぞれ指定したブラウザでのテストが実行されます。

```bash
# Chromeの場合
$ ./gradlew chromeTest

# Firefoxの場合
$ ./gradlew firefoxTest

# PhantomJSの場合
$ ./gradlew phantomJsTest
```

### 複数ブラウザで実行

下記のコマンドを実行すると、複数ブラウザでのテストが走ります。

```bash
$ ./gradlew test
```

## 参考
下記を参考にしています。
* https://github.com/geb/geb-example-gradle


## ライセンス
Apache License, Version 2.0です (詳しくはプロジェクト直下のLICENSEをご覧ください。)