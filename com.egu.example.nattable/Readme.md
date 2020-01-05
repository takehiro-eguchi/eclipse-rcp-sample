# com.egu.example.nattable

## NATTableとは
テーブル、グリッド、およびツリーコントロールを作成するためのフレームワークです。
豊富な機能セットがあり、非常に大きなデータセットを処理するように設計されています。
たとえば、並べ替え、フィルタリング、グループ化、固定/固定列や行など、
現在のテーブル実装にユーザーが期待する多くの機能が備わっています。
特徴は以下の通り

* 多数の列を持つ巨大なデータセットを処理できます
* 完全なスタイリング機能（列ヘッダーのスタイリングなど）
* テーブル内の異なる行の高さのサポート
* ソート、フィルタリング、スタイル設定、グループ化、動的更新などの高度なテーブル機能用のシンプルなAPI

## バンドルおよび依存関係
**NatTable Core** と **NatTable Extensions** で構成される。

* NatTable Core
    * SWT - rendering and interaction (key, mouse)
    * JFace - resource handling and dialogs
    * org.eclipse.equinox.common & org.eclipse.core.commands - JFace dependencies
    * Apache Commons Logging - internal logging

* NatTable Extensions
    * The Eclipse 4 extension ( >Neon(4.6))
    * GlazedLists extension (depends on Apache Commons Codec)
    * Nebula extension (ICellEditorとICellPainter) ( >Luna(4.4))
    * Apache POI extension

## NatTableのインストール
「ヘルプ」→「新規ソフトウェアのインストール」を選択し、対象に以下のURLを入力
http://download.eclipse.org/nattable/releases/1.5.0/repository/
**NatTable Core** と **NatTable extensions** をインストールする。

## プロジェクトの構築
### プロジェクトの作成
ファイル→新規→その他→プラグイン開発→プラグインプロジェクトを選択。
リッチクライアントアプリケーションを作成することを選択し、Eclipse 4 RCPアプリケーションテンプレートを選択し、
[次へ]をクリック。[サンプルコンテンツの作成]を選択し、[完了]ボタンを押下。

### 依存関係の設定
MANIFEST.MFファイルを開き、次の依存関係を[依存関係]セクションの必須プラグインに追加します。

* org.eclipse.nebula.widgets.nattable.core
* org.eclipse.nebula.widgets.nattable.extension.e4
* org.eclipse.nebula.widgets.nattable.extension.glazedlists
* org.eclipse.nebula.widgets.nattable.extension.nebula

製品定義ファイルを開き、IDフィールドにcom.egu.example.nattable.productを入力します。
