# com.egu.exsample.swt.widgets

## 概要
https://www.vogella.com/tutorials/SWT/article.html#optional-exercise-use-swt-in-a-standalone-java-application
を元に実装

## レイアウトマネージャ

* AbsoluteLayout
    * コンポーネントの正確な位置、幅、高さを設定できるが、推奨されない。
* FillLayout
    * 同一のサイズのウィジェットを単一の列または行に配置する
* RowLayout
    * 行または列にウィジェットを配置し、ラップ、間隔、塗りつぶしなどのオプションを使用して制御可能。
* GridLayout
    * ウィジェットをグリッドに配置できる
* FormLayout
    * 関連する添付を利用してウィジェットの配置を行う。
* StackLayout
    * このレイアウトは、すべてのコントロールの上部にスタックし、すべてのコントロールのサイズと位置が同じになるようにサイズを変更します。 topControlで指定されたコントロールは表示され、他のすべてのコントロールは表示されません。

