リズムゲー的タイピングゲーム  
"Typing game" Made by MYTIA  

大学一年の時のJavaプログラミングの授業のグループワーク。  

ターミナル(コマンドプロンプト)にてMainFrameがあるディレクトリに移動し、
```
javac MainFrame.java
```
でコンパイル、
```
java MainFrame
```
で実行します。  

操作はすべてキーボードで行います。  
降ってくる文字のベースラインが判定ゾーンに入ったときに、対応するキーを押すことでスコアが加算されます。  
* ずれが2以下：EXCELLENT
* ずれが10以下：GREAT
* ずれが20以下：NICE

間違ったキーを押すとスコアが減点されます。  
また、文字が最下段に到達するとライフが減ります。  
ライフがなくなるとゲームオーバーです。
